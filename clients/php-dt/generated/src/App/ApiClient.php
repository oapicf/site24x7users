<?php
declare(strict_types=1);

namespace App;

use Articus\DataTransfer as DT;
use OpenAPIGenerator\APIClient as OAGAC;
use Psr\Http\Client\ClientExceptionInterface;
use Psr\Http\Message\ResponseInterface;

/**
 * swaggy-c-example
 * Example OpenAPI specification for Swaggy C using Google Search
 * The version of the OpenAPI document: 0.0.1-pre.0
 */
class ApiClient extends OAGAC\AbstractApiClient
{
    //region search
    /**
     * Search with a query
     * @param \App\DTO\SearchParameterData $parameters
     * @param string $responseMediaType
     * @return ResponseInterface
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     */
    public function searchRaw(
        \App\DTO\SearchParameterData $parameters,
        string $responseMediaType = 'text/plain'
    ): ResponseInterface
    {
        $request = $this->createRequest('GET', '/search', [], $this->getQueryParameters($parameters));
        $request = $this->addAcceptHeader($request, $responseMediaType);
        return $this->httpClient->sendRequest($request);
    }

    /**
     * Search with a query
     * @param \App\DTO\SearchParameterData $parameters
     * @param string $responseMediaType
     * @return array
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     */
    public function search(
        \App\DTO\SearchParameterData $parameters,
        string $responseMediaType = 'text/plain'
    ): array
    {
        $response = $this->searchRaw($parameters, $responseMediaType);
        $responseContent = null;
        $contentStrategy = null;
        $contentValidator = null;
        switch ($response->getStatusCode())
        {
            case 200:
                /* Search HTML response */
                break;
        }
        $this->parseBody($response, $responseContent, $contentStrategy, $contentValidator);
        return [$responseContent, $response->getHeaders(), $response->getStatusCode(), $response->getReasonPhrase()];
    }

    /**
     * Search with a query
     * @param \App\DTO\SearchParameterData $parameters
     * @param string $responseMediaType
     * @return string
     * @throws ClientExceptionInterface
     * @throws DT\Exception\InvalidData
     * @throws OAGAC\Exception\InvalidResponseBodySchema
     * @throws OAGAC\Exception\UnsuccessfulResponse
     */
    public function searchResult(
        \App\DTO\SearchParameterData $parameters,
        string $responseMediaType = 'text/plain'
    ): string
    {
        return $this->getSuccessfulContent(...$this->search($parameters, $responseMediaType));
    }
    //endregion
}

