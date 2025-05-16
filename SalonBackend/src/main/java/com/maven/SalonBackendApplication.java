package com.maven;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "LAUNDRY-APP project REST API Documentation",
                description = "LAUNDRY application REST API Documentation",
                version="v1",
                contact = @Contact(
                        name = "Code-crafter",
                        email = "info@code-crafter.in",
                        url = "https://code-crafter.in"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "SANTOSH-ROOFING application REST API Documentation",
                url = "https://code-crafter.in"
        )
)
@SpringBootApplication
public class SalonBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalonBackendApplication.class, args);
    }

}
