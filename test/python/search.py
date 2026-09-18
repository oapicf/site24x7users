import unittest
import openapi_client
from openapi_client.rest import ApiException
from pprint import pprint

class TestGoogle(unittest.TestCase):

    def test_search_with_query(self):

      configuration = openapi_client.Configuration(
          host = "https://google.com"
      )

      with openapi_client.ApiClient(configuration) as api_client:

          api_instance = openapi_client.DefaultApi(api_client)
          q = 'OpenAPI Generator web site'

          try:
              api_response = api_instance.search(q)
              print('The response of DefaultApi->search:\n')
              pprint(api_response)
          except ApiException as e:
              self.fail('Exception when calling DefaultApi->search: %s\n' % e)
