package api

import org.openapitools.OpenApiExceptions
import javax.inject.{Inject, Singleton}
import play.api.libs.json._
import play.api.mvc._

@javax.annotation.Generated(value = Array("org.openapitools.codegen.languages.ScalaPlayFrameworkServerCodegen"), date = "2026-09-19T00:40:43.299721046Z[Etc/UTC]", comments = "Generator version: 7.24.0")
@Singleton
class DefaultApiController @Inject()(cc: ControllerComponents, api: DefaultApi) extends AbstractController(cc) {
  /**
    * GET /search?q=[value]
    */
  def search(): Action[AnyContent] = Action { request =>
    def executeApi(): String = {
      val q = request.getQueryString("q")
        .getOrElse {
          throw new OpenApiExceptions.MissingRequiredParameterException("q", "query string")
        }
        
      api.search(q)
    }

    val result = executeApi()
    val json = Json.toJson(result)
    Ok(json)
  }

  private def splitCollectionParam(paramValues: String, collectionFormat: String): List[String] = {
    val splitBy =
      collectionFormat match {
        case "csv" => ",+"
        case "tsv" => "\t+"
        case "ssv" => " +"
        case "pipes" => "|+"
      }

    paramValues.split(splitBy).toList
  }
}
