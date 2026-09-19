package org.openapitools.api;

import org.openapitools.model.*;
import org.openapitools.api.SearchApiService;
import org.openapitools.api.factories.SearchApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;


import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import org.wso2.msf4j.formparam.FormDataParam;
import org.wso2.msf4j.formparam.FileInfo;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/search")


@io.swagger.annotations.Api(description = "the search API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaMSF4JServerCodegen", date = "2026-09-19T00:38:39.875277785Z[Etc/UTC]", comments = "Generator version: 7.24.0")
public class SearchApi  {
   private final SearchApiService delegate = SearchApiServiceFactory.getSearchApi();

    @GET
    
    
    @Produces({ "text/plain" })
    @io.swagger.annotations.ApiOperation(value = "Search with a query", notes = "", response = String.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Search HTML response", response = String.class) })
    public Response search(@ApiParam(value = "",required=true) @QueryParam("q") String q
)
    throws NotFoundException {
        return delegate.search(q);
    }
}
