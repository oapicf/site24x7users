package org.openapitools.api.factories;

import org.openapitools.api.SearchApiService;
import org.openapitools.api.impl.SearchApiServiceImpl;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2026-09-19T00:38:53.662407439Z[Etc/UTC]", comments = "Generator version: 7.24.0")
public class SearchApiServiceFactory {
    private static final SearchApiService service = new SearchApiServiceImpl();

    public static SearchApiService getSearchApi() {
        return service;
    }
}
