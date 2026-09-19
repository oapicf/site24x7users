# DefaultApi

All URIs are relative to *https://google.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**search**](DefaultApi.md#search) | **GET** /search | Search with a query


# **search**
> `search`(_api::`DefaultApi`, `q`::`String`; _mediaType=nothing) -> `String`, `OpenAPI.Clients.ApiResponse` <br/>
> `search`(_api::`DefaultApi`, response_stream::`Channel`, `q`::`String`; _mediaType=nothing) -> `Channel`{ `String` }, `OpenAPI.Clients.ApiResponse`

Search with a query

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **_api** | **`DefaultApi`** | API context | 
**`q`** | **`String`** |  |

### Return type

**`String`**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

[[Back to top]](#) [[Back to API list]](../README.md#api-endpoints) [[Back to Model list]](../README.md#models) [[Back to README]](../README.md)

