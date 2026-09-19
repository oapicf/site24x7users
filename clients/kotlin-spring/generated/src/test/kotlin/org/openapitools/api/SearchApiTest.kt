package org.openapitools.api

import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity

class SearchApiTest {

    private val api: SearchApiController = SearchApiController()

    /**
     * To test SearchApiController.search
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun searchTest() {
        val q: kotlin.String = TODO()
        
        
        val response: ResponseEntity<kotlin.String> = api.search(q)

        // TODO: test validations
    }
}
