/*
 * swaggy-c-example
 *
 * Example OpenAPI specification for Swaggy C using Google Search
 *
 * OpenAPI document version: 0.0.1-pre.0
 * Maintained by: blah+oapicf@cliffano.com
 *
 * AUTO-GENERATED FILE, DO NOT MODIFY!
 */
package org.openapitools.handler;

import io.undertow.server.*;
import io.undertow.util.*;

import org.openapitools.model.*;

@SuppressWarnings("TooManyFunctions")
public interface PathHandlerInterface {

    /**
     * <p>Search with a query</p>
     *
     * <p><b>Endpoint</b>: {@link Methods#GET GET} "/search" (<i>privileged: false</i>)</p>
     *
     * <p><b>Request parameters</b>:</p>
     * <ul>
     * <li>
     * <p>"<b>q</b>"
     * <p>
     * - Parameter type: <b>{@link String}</b><br/>
     * - Appears in: <b>{@link HttpServerExchange#getQueryParameters Query}</b><br/>
     * - Required: <b>true</b>
     * </p>
     * </li>
     * </ul>
     *
     * <p><b>Produces</b>: [{mediaType=text/plain}]</p>
     * <p><b>Returns</b>: {@link String}</p>
     *
     * <p><b>Responses</b>:</p>
     * <ul>
     * <li><b>200 (success)</b>: Search HTML response</li>
     * </ul>
     */
    @javax.annotation.Nonnull
    HttpHandler search();
}
