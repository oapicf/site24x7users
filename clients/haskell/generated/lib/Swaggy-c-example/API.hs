{-# LANGUAGE DataKinds                  #-}
{-# LANGUAGE DeriveDataTypeable         #-}
{-# LANGUAGE DeriveGeneric              #-}
{-# LANGUAGE DeriveTraversable          #-}
{-# LANGUAGE FlexibleContexts           #-}
{-# LANGUAGE FlexibleInstances          #-}
{-# LANGUAGE GeneralizedNewtypeDeriving #-}
{-# LANGUAGE OverloadedStrings          #-}
{-# LANGUAGE RecordWildCards            #-}
{-# LANGUAGE TypeFamilies               #-}
{-# LANGUAGE TypeOperators              #-}
{-# LANGUAGE ViewPatterns               #-}
{-# OPTIONS_GHC
-fno-warn-unused-binds -fno-warn-unused-imports -freduction-depth=328 #-}

module Swaggy-c-example.API
  ( -- * Client and Server
    Config(..)
  , Swaggy-c-exampleBackend(..)
  , createSwaggy-c-exampleClient
  , runSwaggy-c-exampleServer
  , runSwaggy-c-exampleMiddlewareServer
  , runSwaggy-c-exampleClient
  , runSwaggy-c-exampleClientWithManager
  , callSwaggy-c-example
  , Swaggy-c-exampleClient
  , Swaggy-c-exampleClientError(..)
  -- ** Servant
  , Swaggy-c-exampleAPI
  -- ** Plain WAI Application
  , serverWaiApplicationSwaggy-c-example
  ) where

import           Swaggy-c-example.Types

import           Control.Monad.Catch                (Exception, MonadThrow, throwM)
import           Control.Monad.Except               (ExceptT, runExceptT)
import           Control.Monad.IO.Class
import           Control.Monad.Trans.Reader         (ReaderT (..))
import           Data.Aeson                         (Value)
import qualified Data.Aeson                         as Aeson
import qualified Data.ByteString.Lazy               as BSL
import           Data.Coerce                        (coerce)
import           Data.Data                          (Data)
import           Data.Function                      ((&))
import qualified Data.Map                           as Map
import           Data.Monoid                        ((<>))
import           Data.Proxy                         (Proxy (..))
import           Data.Set                           (Set)
import           Data.Text                          (Text)
import qualified Data.Text                          as T
import qualified Data.Text.Encoding                 as T
import           Data.Time
import           Data.UUID                          (UUID)
import           GHC.Exts                           (IsString (..))
import           GHC.Generics                       (Generic)
import           Network.HTTP.Client                (Manager, newManager)
import           Network.HTTP.Client.TLS            (tlsManagerSettings)
import           Network.HTTP.Types.Method          (methodOptions)
import           Network.Wai                        (Middleware)
import qualified Network.Wai.Handler.Warp           as Warp
import           Servant                            (ServerError, serveWithContextT)
import           Servant.API                        hiding (addHeader)
import           Servant.API.Verbs                  (StdMethod (..), Verb)
import           Servant.Client                     (ClientEnv, Scheme (Http), ClientError, client,
                                                     mkClientEnv, parseBaseUrl)
import           Servant.Client.Core                (baseUrlPort, baseUrlHost)
import           Servant.Client.Internal.HttpClient (ClientM (..))
import           Servant.Server                     (Handler (..), Application, Context (EmptyContext))
import           Servant.Server.StaticFiles         (serveDirectoryFileServer)
import           Web.FormUrlEncoded
import           Web.HttpApiData




-- | List of elements parsed from a query.
newtype QueryList (p :: CollectionFormat) a = QueryList
  { fromQueryList :: [a]
  } deriving (Functor, Applicative, Monad, Foldable, Traversable)

-- | Formats in which a list can be encoded into a HTTP path.
data CollectionFormat
  = CommaSeparated -- ^ CSV format for multiple parameters.
  | SpaceSeparated -- ^ Also called "SSV"
  | TabSeparated -- ^ Also called "TSV"
  | PipeSeparated -- ^ `value1|value2|value2`
  | MultiParamArray -- ^ Using multiple GET parameters, e.g. `foo=bar&foo=baz`. Only for GET params.

instance FromHttpApiData a => FromHttpApiData (QueryList 'CommaSeparated a) where
  parseQueryParam = parseSeparatedQueryList ','

instance FromHttpApiData a => FromHttpApiData (QueryList 'TabSeparated a) where
  parseQueryParam = parseSeparatedQueryList '\t'

instance FromHttpApiData a => FromHttpApiData (QueryList 'SpaceSeparated a) where
  parseQueryParam = parseSeparatedQueryList ' '

instance FromHttpApiData a => FromHttpApiData (QueryList 'PipeSeparated a) where
  parseQueryParam = parseSeparatedQueryList '|'

instance FromHttpApiData a => FromHttpApiData (QueryList 'MultiParamArray a) where
  parseQueryParam = error "unimplemented FromHttpApiData for MultiParamArray collection format"

parseSeparatedQueryList :: FromHttpApiData a => Char -> Text -> Either Text (QueryList p a)
parseSeparatedQueryList char = fmap QueryList . mapM parseQueryParam . T.split (== char)

instance ToHttpApiData a => ToHttpApiData (QueryList 'CommaSeparated a) where
  toQueryParam = formatSeparatedQueryList ','

instance ToHttpApiData a => ToHttpApiData (QueryList 'TabSeparated a) where
  toQueryParam = formatSeparatedQueryList '\t'

instance ToHttpApiData a => ToHttpApiData (QueryList 'SpaceSeparated a) where
  toQueryParam = formatSeparatedQueryList ' '

instance ToHttpApiData a => ToHttpApiData (QueryList 'PipeSeparated a) where
  toQueryParam = formatSeparatedQueryList '|'

instance ToHttpApiData a => ToHttpApiData (QueryList 'MultiParamArray a) where
  toQueryParam = error "unimplemented ToHttpApiData for MultiParamArray collection format"

formatSeparatedQueryList :: ToHttpApiData a => Char ->  QueryList p a -> Text
formatSeparatedQueryList char = T.intercalate (T.singleton char) . map toQueryParam . fromQueryList

newtype JSONQueryParam a = JSONQueryParam
  { fromJsonQueryParam :: a
  } deriving (Functor, Foldable, Traversable)

instance Aeson.ToJSON a => ToHttpApiData (JSONQueryParam a) where
  toQueryParam = T.decodeUtf8 . BSL.toStrict . Aeson.encode . fromJsonQueryParam

instance Aeson.FromJSON a => FromHttpApiData (JSONQueryParam a) where
  parseQueryParam = either (Left . T.pack) (Right . JSONQueryParam) . Aeson.eitherDecodeStrict . T.encodeUtf8


-- | Servant type-level API, generated from the OpenAPI spec for Swaggy-c-example.
type Swaggy-c-exampleAPI
    =    "search" :> QueryParam "q" Text :> Verb 'GET 200 '[JSON] Text -- 'search' route
    :<|> Raw


-- | Server or client configuration, specifying the host and port to query or serve on.
data Config = Config
  { configUrl :: String  -- ^ scheme://hostname:port/path, e.g. "http://localhost:8080/"
  } deriving (Eq, Ord, Show, Read)


-- | Custom exception type for our errors.
newtype Swaggy-c-exampleClientError = Swaggy-c-exampleClientError ClientError
  deriving (Show, Exception)
-- | Configuration, specifying the full url of the service.


-- | Backend for Swaggy-c-example.
-- The backend can be used both for the client and the server. The client generated from the Swaggy-c-example OpenAPI spec
-- is a backend that executes actions by sending HTTP requests (see @createSwaggy-c-exampleClient@). Alternatively, provided
-- a backend, the API can be served using @runSwaggy-c-exampleMiddlewareServer@.
data Swaggy-c-exampleBackend m = Swaggy-c-exampleBackend
  { search :: Maybe Text -> m Text{- ^  -}
  }


newtype Swaggy-c-exampleClient a = Swaggy-c-exampleClient
  { runClient :: ClientEnv -> ExceptT ClientError IO a
  } deriving Functor

instance Applicative Swaggy-c-exampleClient where
  pure x = Swaggy-c-exampleClient (\_ -> pure x)
  (Swaggy-c-exampleClient f) <*> (Swaggy-c-exampleClient x) =
    Swaggy-c-exampleClient (\env -> f env <*> x env)

instance Monad Swaggy-c-exampleClient where
  (Swaggy-c-exampleClient a) >>= f =
    Swaggy-c-exampleClient (\env -> do
      value <- a env
      runClient (f value) env)

instance MonadIO Swaggy-c-exampleClient where
  liftIO io = Swaggy-c-exampleClient (\_ -> liftIO io)

createSwaggy-c-exampleClient :: Swaggy-c-exampleBackend Swaggy-c-exampleClient
createSwaggy-c-exampleClient = Swaggy-c-exampleBackend{..}
  where
    ((coerce -> search) :<|>
     _) = client (Proxy :: Proxy Swaggy-c-exampleAPI)

-- | Run requests in the Swaggy-c-exampleClient monad.
runSwaggy-c-exampleClient :: Config -> Swaggy-c-exampleClient a -> ExceptT ClientError IO a
runSwaggy-c-exampleClient clientConfig cl = do
  manager <- liftIO $ newManager tlsManagerSettings
  runSwaggy-c-exampleClientWithManager manager clientConfig cl

-- | Run requests in the Swaggy-c-exampleClient monad using a custom manager.
runSwaggy-c-exampleClientWithManager :: Manager -> Config -> Swaggy-c-exampleClient a -> ExceptT ClientError IO a
runSwaggy-c-exampleClientWithManager manager Config{..} cl = do
  url <- parseBaseUrl configUrl
  runClient cl $ mkClientEnv manager url

-- | Like @runClient@, but returns the response or throws
--   a Swaggy-c-exampleClientError
callSwaggy-c-example
  :: (MonadIO m, MonadThrow m)
  => ClientEnv -> Swaggy-c-exampleClient a -> m a
callSwaggy-c-example env f = do
  res <- liftIO $ runExceptT $ runClient f env
  case res of
    Left err       -> throwM (Swaggy-c-exampleClientError err)
    Right response -> pure response


requestMiddlewareId :: Application -> Application
requestMiddlewareId a = a

-- | Run the Swaggy-c-example server at the provided host and port.
runSwaggy-c-exampleServer
  :: (MonadIO m, MonadThrow m)
  => Config -> Swaggy-c-exampleBackend (ExceptT ServerError IO) -> m ()
runSwaggy-c-exampleServer config backend = runSwaggy-c-exampleMiddlewareServer config requestMiddlewareId backend

-- | Run the Swaggy-c-example server at the provided host and port.
runSwaggy-c-exampleMiddlewareServer
  :: (MonadIO m, MonadThrow m)
  => Config -> Middleware -> Swaggy-c-exampleBackend (ExceptT ServerError IO) -> m ()
runSwaggy-c-exampleMiddlewareServer Config{..} middleware backend = do
  url <- parseBaseUrl configUrl
  let warpSettings = Warp.defaultSettings
        & Warp.setPort (baseUrlPort url)
        & Warp.setHost (fromString $ baseUrlHost url)
  liftIO $ Warp.runSettings warpSettings $ middleware $ serverWaiApplicationSwaggy-c-example backend

-- | Plain "Network.Wai" Application for the Swaggy-c-example server.
--
-- Can be used to implement e.g. tests that call the API without a full webserver.
serverWaiApplicationSwaggy-c-example :: Swaggy-c-exampleBackend (ExceptT ServerError IO) -> Application
serverWaiApplicationSwaggy-c-example backend = serveWithContextT (Proxy :: Proxy Swaggy-c-exampleAPI) context id (serverFromBackend backend)
  where
    context = serverContext
    serverFromBackend Swaggy-c-exampleBackend{..} =
      (coerce search :<|>
       serveDirectoryFileServer "static")


serverContext :: Context ('[])
serverContext = EmptyContext
