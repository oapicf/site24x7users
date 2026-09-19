package org.openapitools.api.interfaces;

import java.util.List;
import java.util.Map;
import java.time.OffsetDateTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;


@Generated(value = "org.openapitools.codegen.languages.JavaDubboServerCodegen", comments = "Generator version: 7.24.0")

public interface SearchService {

    /**
     * Search with a query
     * 
     *
     * @param q  (required)
     * @return String
     */
    String search(
        String q
    );
}
