package com.jio.platform.u202124304.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI learningPlatformOpenApi() {
        final String securitySchemaName = "bearerAuth";
        var openApi = new OpenAPI();
        openApi
                .info(new Info()
                        .title("ISA Connect Platform API")
                        .description("ISA Connect Platform application REST API documentation.")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")
                                .url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("ISA Connect Platform wiki Documentation")
                        .url("https://isa-connect-latform.wiki.github.io/docs"));

        return openApi;
    }
}