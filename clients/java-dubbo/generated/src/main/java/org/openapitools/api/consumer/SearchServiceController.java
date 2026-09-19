package org.openapitools.api.consumer;

import org.openapitools.api.interfaces.SearchService;
import java.util.List;
import java.util.Map;
import java.time.OffsetDateTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Generated;


@Generated(value = "org.openapitools.codegen.languages.JavaDubboServerCodegen", comments = "Generator version: 7.24.0")

@RestController
@RequestMapping("/search")
public class SearchServiceController {

    @DubboReference
    private SearchService searchService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String search(
        @RequestParam(name = "q") String q
    ) {
        return searchService.search(q);
    }
}
