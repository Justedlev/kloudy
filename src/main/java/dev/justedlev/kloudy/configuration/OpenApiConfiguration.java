package dev.justedlev.kloudy.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.security.config.Elements;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Justedlev",
                        email = "justedlevhub@gmail.com"
                ),
                description = "Users Service APIs Documentation",
                title = "OpenApi specification - Justedlevhub Users APIs",
                version = "v1.0",
                license = @License(
                        name = "Apache 2.0",
                        url = "https://springdoc.org"
                )
        ),
        servers = {
                @Server(
                        description = "Gateway ENV",
                        url = "${application.service.url}"
                ),
        },
        security = {
                @SecurityRequirement(name = "OAuth2"),
                @SecurityRequirement(name = "bearer-auth"),
        }
)
@SecurityScheme(
        name = "OAuth2",
        description = "Authentication by OAuth2 protocol",
        scheme = "Bearer",
        type = SecuritySchemeType.OAUTH2,
        bearerFormat = Elements.JWT,
        in = SecuritySchemeIn.COOKIE,
        flows = @OAuthFlows(
                password = @OAuthFlow(
                        tokenUrl = "${keycloak.token-uri}",
                        refreshUrl = "${keycloak.token-uri}"
                ),
                clientCredentials = @OAuthFlow(
                        tokenUrl = "${keycloak.token-uri}",
                        refreshUrl = "${keycloak.token-uri}"
                )
        )
)
@SecurityScheme(
        name = "bearer-auth",
        description = "Authentication by JWT",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = Elements.JWT,
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfiguration {
}
