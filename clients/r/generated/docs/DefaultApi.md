# DefaultApi

All URIs are relative to *https://google.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**Search**](DefaultApi.md#Search) | **GET** /search | Search with a query


# **Search**
> character Search(q)

Search with a query

### Example
```R
library(openapi)

# Search with a query
#
# prepare function argument(s)
var_q <- "q_example" # character | 

api_instance <- DefaultApi$new()
# to save the result into a file, simply add the optional `data_file` parameter, e.g.
# result <- api_instance$Search(var_qdata_file = "result.txt")
result <- api_instance$Search(var_q)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **q** | **character**|  | 

### Return type

**character**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Search HTML response |  -  |

