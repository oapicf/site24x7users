package org.openapitools.api;

import org.openapitools.api.ApiUtils

class DefaultApi {
    String basePath = "https://google.com"
    String versionPath = ""
    ApiUtils apiUtils = new ApiUtils();

    def search ( String q, Closure onSuccess, Closure onFailure)  {
        String resourcePath = "/search"

        // params
        def queryParams = [:]
        def headerParams = [:]
        def bodyParams
        def accept
        def contentType

        // verify required params are set
        if (q == null) {
            throw new RuntimeException("missing required params q")
        }

        if (q != null) {
            queryParams.put("q", q)
        }




        accept = apiUtils.selectHeaderAccept(["text/plain"])

        apiUtils.invokeApi(onSuccess, onFailure, basePath, versionPath, resourcePath, queryParams, headerParams, bodyParams, accept, contentType,
                    "GET", "",
                    String.class )

    }

}
