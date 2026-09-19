namespace OpenAPI

open System.Collections.Generic
open Giraffe
open Microsoft.AspNetCore.Http
open FSharp.Control.Tasks.V2.ContextInsensitive
open DefaultApiHandlerParams
open DefaultApiServiceInterface
open DefaultApiServiceImplementation

module DefaultApiHandler =

    /// <summary>
    /// 
    /// </summary>

    //#region Search
    /// <summary>
    /// Search with a query
    /// </summary>

    let Search  : HttpHandler =
      fun (next : HttpFunc) (ctx : HttpContext) ->
        task {
          let queryParams = ctx.TryBindQueryString<SearchQueryParams>()
          let serviceArgs = {  queryParams=queryParams;    } : SearchArgs
          let result = DefaultApiService.Search ctx serviceArgs
          return! (match result with
                      | SearchStatusCode200 resolved ->
                            setStatusCode 200 >=> text resolved.content
          ) next ctx
        }
    //#endregion

