package org.openapitools.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.model.StatusCodes
import org.openapitools.server.AkkaHttpHelper._


class DefaultApi(
    defaultService: DefaultApiService
) {

  
  
  lazy val route: Route =
    path("search") { 
      get { 
        parameters("q".as[String]) { (q) => 
            defaultService.search(q = q)
        }
      }
    }
}


trait DefaultApiService {

  def search200(responseString: String)(implicit toEntityMarshallerString: ToEntityMarshaller[String]): Route =
    complete((200, responseString))
  /**
   * Code: 200, Message: Search HTML response, DataType: String
   */
  def search(q: String): Route

}


