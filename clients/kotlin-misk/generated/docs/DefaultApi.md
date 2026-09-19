# DefaultApi

All URIs are relative to *https://google.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**search**](DefaultApi.md#search) | **Get** /search | Search with a query


<a name="search"></a>
# **search**
> kotlin.String search(q)

Search with a query

### Example
```kotlin
// Import classes:
//import org.openapitools.infrastructure.*
//import org.openapitools.server.api.model.*

val apiInstance = DefaultApi()
val q : kotlin.String = q_example // kotlin.String | 
try {
    val result : kotlin.String = apiInstance.search(q)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#search")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#search")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **q** | **kotlin.String**|  |

### Return type

**kotlin.String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: TEXT_PLAIN_UTF8

