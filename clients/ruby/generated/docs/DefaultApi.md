# OpenapiClient::DefaultApi

All URIs are relative to *https://google.com*

| Method | HTTP request | Description |
| ------ | ------------ | ----------- |
| [**search**](DefaultApi.md#search) | **GET** /search | Search with a query |


## search

> String search(q)

Search with a query

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::DefaultApi.new
q = 'q_example' # String | 

begin
  # Search with a query
  result = api_instance.search(q)
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling DefaultApi->search: #{e}"
end
```

#### Using the search_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> search_with_http_info(q)

```ruby
begin
  # Search with a query
  data, status_code, headers = api_instance.search_with_http_info(q)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling DefaultApi->search_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **q** | **String** |  |  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/plain

