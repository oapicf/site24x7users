package org.openapitools.api;

import org.openapitools.api.*;
import org.openapitools.model.*;




import java.util.List;
import org.openapitools.api.NotFoundException;

import java.io.InputStream;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2026-09-19T00:38:56.713405719Z[Etc/UTC]", comments = "Generator version: 7.24.0")
public interface SearchApiService {
      Response search(String q,SecurityContext securityContext)
      throws NotFoundException;


}
