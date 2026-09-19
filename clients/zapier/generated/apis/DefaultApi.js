const samples = require('../samples/DefaultApi');
const utils = require('../utils/utils');

module.exports = {
    search: {
        key: 'search',
        noun: 'default',
        display: {
            label: 'Search with a query',
            description: '',
            hidden: false,
        },
        operation: {
            inputFields: [
                {
                    key: 'q',
                    label: '',
                    type: 'string',
                    required: true,
                },
            ],
            outputFields: [
            ],
            perform: async (z, bundle) => {
                const options = {
                    url: utils.replacePathParameters('https://google.com/search'),
                    method: 'GET',
                    removeMissingValuesFrom: { params: true, body: true },
                    headers: {
                        'Content-Type': '',
                        'Accept': 'text/plain',
                    },
                    params: {
                        'q': bundle.inputData?.['q'],
                    },
                    body: {
                    },
                }
                return z.request(utils.requestOptionsMiddleware(z, bundle, options)).then((response) => {
                    response.throwForStatus();
                    const results = utils.responseOptionsMiddleware(z, bundle, 'search', response.json);
                    return { data: results };
                })
            },
            sample: { data: {} }
        }
    },
}
