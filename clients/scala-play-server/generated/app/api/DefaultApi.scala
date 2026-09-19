package api

import play.api.libs.json._

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"), date = "2026-09-19T00:40:43.299721046Z[Etc/UTC]", comments = "Generator version: 7.24.0")
trait DefaultApi {
  /**
    * Search with a query
    */
  def search(q: String): String
}
