# \DefaultAPI

All URIs are relative to *https://google.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**Search**](DefaultAPI.md#Search) | **Get** /search | Search with a query



## Search

> string Search(ctx).Q(q).Execute()

Search with a query

### Example

```go
package main

import (
	"context"
	"fmt"
	"os"
	openapiclient "github.com/null/null"
)

func main() {
	q := "q_example" // string | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.DefaultAPI.Search(context.Background()).Q(q).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `DefaultAPI.Search``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `Search`: string
	fmt.Fprintf(os.Stdout, "Response from `DefaultAPI.Search`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiSearchRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **q** | **string** |  | 

### Return type

**string**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

