{-# LANGUAGE NoImplicitPrelude #-}
{-# LANGUAGE OverloadedStrings #-}
module Handler.DefaultSpec (spec) where

import           TestImport


spec :: Spec
spec = withApp $ do

    describe "getSearchR" $
        it "returns 501 Not Implemented" $ do
            get SearchR
            statusIs 501
