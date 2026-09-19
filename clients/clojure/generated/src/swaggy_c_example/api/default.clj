(ns swaggy-c-example.api.default
  (:require [swaggy-c-example.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            )
  (:import (java.io File)))


(defn-spec search-with-http-info any?
  "Search with a query"
  [q string?]
  (check-required-params q)
  (call-api "/search" :get
            {:path-params   {}
             :header-params {}
             :query-params  {"q" q }
             :form-params   {}
             :content-types []
             :accepts       ["text/plain"]
             :auth-names    []}))

(defn-spec search string?
  "Search with a query"
  [q string?]
  (let [res (:data (search-with-http-info q))]
    (if (:decode-models *api-context*)
       (st/decode string? res st/string-transformer)
       res)))


