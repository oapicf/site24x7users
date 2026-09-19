namespace OpenAPI
open DefaultApiHandlerParams
open DefaultApiServiceInterface
open System.Collections.Generic
open System

module DefaultApiServiceImplementation =

    //#region Service implementation
    type DefaultApiServiceImpl() =
      interface IDefaultApiService with

        member this.Search () =
            let content = "Search HTML response" :> obj :?> string // this cast is obviously wrong, and is only intended to allow generated project to compile   
            SearchStatusCode200 { content = content }

      //#endregion

    let DefaultApiService = DefaultApiServiceImpl() :> IDefaultApiService