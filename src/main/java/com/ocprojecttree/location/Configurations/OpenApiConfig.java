package com.ocprojecttree.location.Configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "BALDE",
                        email = "balde@formation.com",
                        url = "https://projet3openclassrooms.fr"
                ),
                description = "Documentation OpenApi pour le projet 3 back end",
                title = "Back end projet 3",
                version = "1.0",
                license = @License(
                        name = "Copyright @2024",
                        url = "https://licenceduprojet3.com"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "local Dev",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "GitHub",
                        url = "https://github.com/Balde2022/location.git"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "Jwt auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
