# OAIDefaultApi

All URIs are relative to *https://google.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**search**](OAIDefaultApi.md#search) | **GET** /search | Search with a query


# **search**
```objc
-(NSURLSessionTask*) searchWithQ: (NSString*) q
        completionHandler: (void (^)(NSString* output, NSError* error)) handler;
```

Search with a query

### Example
```objc

NSString* q = @"q_example"; // 

OAIDefaultApi*apiInstance = [[OAIDefaultApi alloc] init];

// Search with a query
[apiInstance searchWithQ:q
          completionHandler: ^(NSString* output, NSError* error) {
                        if (output) {
                            NSLog(@"%@", output);
                        }
                        if (error) {
                            NSLog(@"Error calling OAIDefaultApi->search: %@", error);
                        }
                    }];
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **q** | **NSString***|  | 

### Return type

**NSString***

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

