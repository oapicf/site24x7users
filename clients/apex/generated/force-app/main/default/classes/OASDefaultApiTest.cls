@isTest
private class OASDefaultApiTest {
    /**
     * Search with a query
     *
     * 
     */
    @isTest
    private static void searchTest() {
        HttpResponse res = new HttpResponse();
        res.setStatusCode(200);
        res.setStatus('OK');
        Test.setMock(HttpCalloutMock.class, new OASResponseMock(res));

        Map<String, Object> params = new Map<String, Object>{
            'q' => 'null'
        };

        OASClient client;
        OASDefaultApi api;
        String response;
        String expectedResponse;
        String js = '';

        api = new OASDefaultApi(new OASClient());

        api.search(params);
    }
}