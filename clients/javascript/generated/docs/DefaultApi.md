# SwaggyCExample.DefaultApi

All URIs are relative to *https://google.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**search**](DefaultApi.md#search) | **GET** /search | Search with a query



## search

> String search(q)

Search with a query

### Example

```javascript
import SwaggyCExample from 'swaggy_c_example';

let apiInstance = new SwaggyCExample.DefaultApi();
let q = "q_example"; // String | 
apiInstance.search(q, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **q** | **String**|  | 

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/plain

