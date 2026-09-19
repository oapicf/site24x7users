require 'json'


MyApp.add_route('GET', '/search', {
  "resourcePath" => "/Default",
  "summary" => "Search with a query",
  "nickname" => "search",
  "responseClass" => "String",
  "endpoint" => "/search",
  "notes" => "",
  "parameters" => [
    {
      "name" => "q",
      "description" => "",
      "dataType" => "String",
      "allowableValues" => "",
      "paramType" => "query",
    },
    ]}) do
  cross_origin
  # the guts live here

  {"message" => "yes, it worked"}.to_json
end

