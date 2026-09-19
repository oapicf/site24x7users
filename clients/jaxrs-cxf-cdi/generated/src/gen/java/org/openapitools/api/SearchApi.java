package org.openapitools.api;

import org.openapitools.api.SearchApiService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import io.swagger.annotations.*;
import java.io.InputStream;

import org.apache.cxf.jaxrs.ext.PATCH;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import java.util.Map;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
@Path("/search")
@RequestScoped

@Api


@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSCXFCDIServerCodegen", date = "2026-09-19T00:38:52.125136596Z[Etc/UTC]", comments = "Generator version: 7.24.0")

public class SearchApi  {

  @Context SecurityContext securityContext;

  @Inject SearchApiService delegate;


    @GET
    
    
    @Produces({ "text/plain" })
    @ApiOperation(value = "Search with a query", notes = "", response = String.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Search HTML response", response = String.class) })
    public Response search( @NotNull @ApiParam(value = "",required=true)  @QueryParam("q") String q) {
        return delegate.search(q, securityContext);
    }
}
