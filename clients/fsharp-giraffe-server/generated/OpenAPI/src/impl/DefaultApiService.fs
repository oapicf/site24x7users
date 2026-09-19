namespace OpenAPI
open DefaultApiHandlerParams
open DefaultApiServiceInterface
open System.Collections.Generic
open System
open Giraffe

module DefaultApiServiceImplementation =

    //#region Service implementation
    type DefaultApiServiceImpl() =
      interface IDefaultApiService with

        member this.Search ctx args =
            let content = "Search HTML response" :> obj :?> string // this cast is obviously wrong, and is only intended to allow generated project to compile   
            SearchStatusCode200 { content = content }

      //#endregion

    let DefaultApiService = DefaultApiServiceImpl() :> IDefaultApiService