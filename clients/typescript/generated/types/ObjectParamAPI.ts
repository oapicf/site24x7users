import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../http/http';
import { Configuration, ConfigurationOptions } from '../configuration'
import type { Middleware } from '../middleware';


import { ObservableDefaultApi } from "./ObservableAPI";
import { DefaultApiRequestFactory, DefaultApiResponseProcessor} from "../apis/DefaultApi";

export interface DefaultApiSearchRequest {
    /**
     * 
     * Defaults to: undefined
     * @type string
     * @memberof DefaultApisearch
     */
    q: string
}

export class ObjectDefaultApi {
    private api: ObservableDefaultApi

    public constructor(configuration: Configuration, requestFactory?: DefaultApiRequestFactory, responseProcessor?: DefaultApiResponseProcessor) {
        this.api = new ObservableDefaultApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Search with a query
     * @param param the request object
     */
    public searchWithHttpInfo(param: DefaultApiSearchRequest, options?: ConfigurationOptions): Promise<HttpInfo<string>> {
        return this.api.searchWithHttpInfo(param.q,  options).toPromise();
    }

    /**
     * Search with a query
     * @param param the request object
     */
    public search(param: DefaultApiSearchRequest, options?: ConfigurationOptions): Promise<string> {
        return this.api.search(param.q,  options).toPromise();
    }

}
