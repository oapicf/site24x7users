# coding: utf-8

from fastapi.testclient import TestClient


from pydantic import StrictStr  # noqa: F401


def test_search(client: TestClient):
    """Test case for search

    Search with a query
    """
    params = [("q", 'q_example')]
    headers = {
    }
    # uncomment below to make a request
    #response = client.request(
    #    "GET",
    #    "/search",
    #    headers=headers,
    #    params=params,
    #)

    # uncomment below to assert the status code of the HTTP response
    #assert response.status_code == 200

