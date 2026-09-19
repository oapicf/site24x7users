@file:Suppress(
    "RemoveRedundantQualifierName",
    "UnusedImport",
    "unused",
)

package org.openapitools.apis

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.matching.StringValuePattern
import org.openapitools.models.*

/**
 * WireMock stub request builder.
 */
open class DefaultApiStubs(private val objectMapper: ObjectMapper) {

    /**
     * Construct a stub for the operation search.
     *
     * @param q query parameter q pattern.
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return A [SearchStubBuilder] to configure the response, and the final [MappingBuilder].
     */
    fun search(q: StringValuePattern? = null, configurer: MappingBuilder.() -> MappingBuilder = { this }): SearchStubBuilder =
        SearchStubBuilder(objectMapper, get(urlPathTemplate("/search"))
            .apply { q?.let { withQueryParam("q", it) } }
            .configurer()
        )
}
