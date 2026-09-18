require 'time'
require 'openapi_client'

describe 'Google' do
  before do
  end

  after do
  end

  describe 'test search with query' do
    it 'should call' do
        api_instance = OpenapiClient::DefaultApi.new
        q = 'OpenAPI Generator web site'

        begin
            result = api_instance.search(q)
            puts result
        rescue OpenapiClient::ApiError => e
            puts "Error when calling DefaultApi->search: #{e}"
            fail
        end
    end
  end

end
