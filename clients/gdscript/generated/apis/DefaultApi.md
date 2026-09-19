<a name="__pageTop"></a>
# DefaultApi   { #DefaultApi }


All URIs are relative to *https://google.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**search**](#search) | **GET** `/search` | Search with a query

# **search**   { #search }
<a name="search"></a>

> `search(q: String, on_success: Callable, on_failure: Callable)`

Search with a query



### Example


```gdscript

# Customize configuration
var config := ApiConfig.new()
config.host = "localhost"
config.port = 8080
#config.tls_enabled = true
#config.trusted_chain = preload("res://my_cert_chain.crt")

# Instantiate the api
var api = DefaultApi.new(config)
# You can also provide your own HTTPClient, to re-use it across apis.
#var api = DefaultApi.new(config, client)


# Invoke an endpoint
api.search(
	# q: String = ""   Eg: q_example
	q,
	# On Success
	func(response):  # response is ApiResponse
		prints("Success!", "search", response)
		assert(response.data is string)
		pass  # do things, make stuff
		,
	# On Error
	func(error):  # error is ApiError
		push_error(str(error))
		,
)

```


### Authorization

No authorization required.

[[Back to top]](#__pageTop) \
[[Back to API list]](../README.md#documentation-for-api-endpoints) \
[[Back to Model list]](../README.md#documentation-for-models) \
[[Back to README]](../README.md) \

