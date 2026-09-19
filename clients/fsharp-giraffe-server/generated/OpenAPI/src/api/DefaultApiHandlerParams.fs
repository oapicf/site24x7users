namespace OpenAPI

open System.Collections.Generic
open System

module DefaultApiHandlerParams =


    //#region Query parameters
    [<CLIMutable>]
    type SearchQueryParams = {
      q : string ;

    }
    //#endregion


    type SearchStatusCode200Response = {
      content:string;
      
    }
    type SearchResult = SearchStatusCode200 of SearchStatusCode200Response

    type SearchArgs = {
      queryParams:Result<SearchQueryParams,string>;
    }
