package org.openapitools.api;


import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import org.apache.cxf.jaxrs.ext.multipart.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.swagger.jaxrs.PATCH;

/**
 * swaggy-c-example
 *
 * <p>Example OpenAPI specification for Swaggy C using Google Search
 *
 */
@Path("/search")
@Api(value = "/", description = "")
public interface DefaultApi  {

    /**
     * Search with a query
     *
     */
    @GET
    
    @Produces({ "text/plain" })
    @ApiOperation(value = "Search with a query", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Search HTML response", response = String.class) })
    public String search(@QueryParam("q") String q);
}
