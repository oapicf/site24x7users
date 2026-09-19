# DefaultApi

All URIs are relative to *https://google.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**search**](DefaultApi.md#search) | **GET** /search | Search with a query



## search

> String search(q)

Search with a query

### Example

```java
// Import classes:
//import org.openapitools.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
String q = null; // String | 
try {
    String result = apiInstance.search(q);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#search");
    e.printStackTrace();
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **q** | **String**|  | [default to null]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/plain

