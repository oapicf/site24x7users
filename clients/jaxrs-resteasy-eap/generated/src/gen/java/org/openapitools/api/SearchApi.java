package org.openapitools.api;

import org.openapitools.model.*;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;


import java.util.List;
import java.util.Map;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/search")


@io.swagger.annotations.Api(description = "the search API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyEapServerCodegen", date = "2026-09-19T00:38:58.244917061Z[Etc/UTC]", comments = "Generator version: 7.24.0")
public interface SearchApi  {

    @GET
    
    
    @Produces({ "text/plain" })
    @io.swagger.annotations.ApiOperation(value = "Search with a query", notes = "", response = String.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Search HTML response", response = String.class) })
    public Response search( @NotNull @QueryParam("q") String q,@Context SecurityContext securityContext);
}
