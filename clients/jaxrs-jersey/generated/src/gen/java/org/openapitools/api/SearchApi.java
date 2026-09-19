package org.openapitools.api;

import org.openapitools.api.SearchApiService;
import org.openapitools.api.factories.SearchApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;


import java.util.Map;
import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;
import javax.validation.Valid;

@Path("/search")


@io.swagger.annotations.Api(description = "the search API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2026-09-19T00:38:53.662407439Z[Etc/UTC]", comments = "Generator version: 7.24.0")
public class SearchApi  {
   private final SearchApiService delegate;

   public SearchApi(@Context ServletConfig servletContext) {
      SearchApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("SearchApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (SearchApiService) Class.forName(implClass).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         }
      }

      if (delegate == null) {
         delegate = SearchApiServiceFactory.getSearchApi();
      }

      this.delegate = delegate;
   }

    @javax.ws.rs.GET
    
    
    @Produces({ "text/plain" })
    @io.swagger.annotations.ApiOperation(value = "Search with a query", notes = "", response = String.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Search HTML response", response = String.class)
    })
    public Response search(@ApiParam(value = "", required = true) @QueryParam("q") @NotNull  String q,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.search(q, securityContext);
    }
}
