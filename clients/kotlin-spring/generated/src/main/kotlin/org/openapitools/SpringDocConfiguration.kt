package org.openapitools

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.security.SecurityScheme

@Configuration
class SpringDocConfiguration {

    @Bean
    fun apiInfo(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("swaggy-c-example")
                    .description("Example OpenAPI specification for Swaggy C using Google Search")
                    .contact(
                        Contact()
                            .name("Site24x7 Users")
                            .url("https://github.com/oapicf/site24x7users")
                            .email("blah+oapicf@cliffano.com")
                    )
                    .license(
                        License()
                            .name("MIT")
                                                )
                    .version("0.0.1-pre.0")
            )
    }
}
