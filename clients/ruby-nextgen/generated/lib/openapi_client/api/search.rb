# frozen_string_literal: true

module OpenapiClient
  module Api
    class Search
      def initialize(connection)
        @connection = connection
      end

      def list(q:)
        raise ArgumentError, 'q is required' if q.nil?

        @connection.call(
          :GET,
          '/search',
          type: nil,
          auth: [],
          query: { 'q' => q }
        )
      end
    end
  end
end
