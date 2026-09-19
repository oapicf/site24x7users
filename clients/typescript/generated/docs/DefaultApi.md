# .DefaultApi

All URIs are relative to *https://google.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**search**](DefaultApi.md#search) | **GET** /search | Search with a query


# **search**
> string search()


### Example


```typescript
import { createConfiguration, DefaultApi } from '';
import type { DefaultApiSearchRequest } from '';

const configuration = createConfiguration();
const apiInstance = new DefaultApi(configuration);

const request: DefaultApiSearchRequest = {
  
  q: "q_example",
};

const data = await apiInstance.search(request);
console.log('API called successfully. Returned data:', data);
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **q** | [**string**] |  | defaults to undefined


### Return type

**string**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Search HTML response |  -  |

[[Back to top]](#) [[Back to API list]](README.md#documentation-for-api-endpoints) [[Back to Model list]](README.md#documentation-for-models) [[Back to README]](README.md)


