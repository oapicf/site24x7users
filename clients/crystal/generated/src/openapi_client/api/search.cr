require "json"

module OpenAPIClient
  module Api
  class Search
    def initialize(@conn : Connection); end

    # Search with a query
    def list(*, q : String? = nil) : Response(String)
      @conn.request(String,
        method: :GET,
        path: "/search",
        query: { "q" => q },
        accept: %w[text/plain],
        raw: true,
        auth: %w[])
    end
  end
  end

end
