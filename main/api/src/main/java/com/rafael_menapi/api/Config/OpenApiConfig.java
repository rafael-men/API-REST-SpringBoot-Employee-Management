package com.rafael_menapi.api.Config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(info = @Info(title = "API REST for Learning with MySQL",version = "v0.0.1",description = "Documentation of this api"))
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("API REST for Learning with MySQL")
                        .version("v0.0.1")
                        .description("Documentation of this API"));
    }
}
