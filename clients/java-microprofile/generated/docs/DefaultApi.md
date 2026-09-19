# DefaultApi

All URIs are relative to *https://google.com*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**search**](DefaultApi.md#search) | **GET** /search | Search with a query |



## search

> String search(q)

Search with a query

### Example

```java
// Import classes:
import org.openapitools.server.ApiClient;
import org.openapitools.server.ApiException;
import org.openapitools.server.Configuration;
import org.openapitools.server.models.*;
import org.openapitools.server.api.DefaultApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://google.com");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        String q = "q_example"; // String | 
        try {
            String result = apiInstance.search(q);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#search");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **q** | **String**|  | |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/plain


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Search HTML response |  -  |

