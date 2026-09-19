-module(openapi_api).

-export([ search/1
        ]).

-define(BASE_URL, "").

%% @doc Search with a query
%% 
-spec search(binary()) ->
  openapi_utils:response().
search(Q) ->
  Method      = get,
  Host        = application:get_env(openapi, host, "http://localhost:8080"),
  Path        = ["/search"],
  QueryString = [<<"q=">>, Q, <<"&">>],

  openapi_utils:request(Method, [Host, ?BASE_URL, Path, <<"?">>, QueryString]).

