package org.openapitools.api;


import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import io.swagger.annotations.*;

import java.io.InputStream;
import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
* Represents a collection of functions to interact with the API endpoints.
*/
@Path("/search")
@Api(description = "the search API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2026-09-19T00:38:59.823826877Z[Etc/UTC]", comments = "Generator version: 7.24.0")
public class SearchApi {

    @GET
    @Produces({ "text/plain" })
    @ApiOperation(value = "Search with a query", notes = "", response = String.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Search HTML response", response = String.class)
    })
    public Response search(@QueryParam("q") @NotNull   String q) {
        return Response.ok().entity("magic!").build();
    }
}
