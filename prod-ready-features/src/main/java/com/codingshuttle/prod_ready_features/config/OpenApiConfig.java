package com.codingshuttle.prod_ready_features.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Prod Ready Features API",
                version = "1.0.0",
                description = "REST API documentation for the Prod Ready Features service.",
                contact = @Contact(
                        name = "Samrat Ganguly",
                        url = "https://samratdocs.com/docs"
                ),
                license = @License(name = "Apache 2.0")
        ),
        servers = @Server(url = "http://localhost:9000", description = "Local server")
)
public class OpenApiConfig {
}
