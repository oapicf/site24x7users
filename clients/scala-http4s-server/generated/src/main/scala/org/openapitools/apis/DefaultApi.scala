package org.openapitools.apis

import org.openapitools.apis.path._
import org.openapitools.apis.query._



import cats.Monad
import cats.syntax.all._

import org.http4s._
import org.http4s.circe._
import org.http4s.server._
import org.http4s.headers._
import org.http4s.dsl.Http4sDsl
import org.http4s.circe.CirceEntityEncoder._

final case class DefaultApiRoutes[
  F[_]: JsonDecoder: Monad
](delegate: DefaultApiDelegate[F]) extends Http4sDsl[F] {
  object search {
    import DefaultApiDelegate.searchResponses

    object qQueryParam extends QueryParamDecoderMatcher[String]("q")

    val route = HttpRoutes.of[F] {
      case req @ GET -> Root / "search" :? qQueryParam(q) =>
        delegate.search.handle(req, q, responses)

    }


    val responses: searchResponses[F] = new searchResponses[F] {
      def resp200(): F[Response[F]] = Ok()
    }
  }

  val routes =
    search.route
}

object DefaultApiDelegate {
  trait searchResponses[F[_]] {
    def resp200(): F[Response[F]]
  }

}

trait DefaultApiDelegate[F[_]] {

  trait search {
    import DefaultApiDelegate.searchResponses

    def handle(
      req: Request[F],
      q: String,
      responses: searchResponses[F]
    ): F[Response[F]]

  }
  def search: search

}