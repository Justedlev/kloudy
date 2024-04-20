package dev.justedlev.kloudy.configuration;

import dev.justedlev.kloudy.configuration.properties.KeycloakProperties;
import lombok.NonNull;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfiguration {
    @Bean
    public Keycloak keycloak(@NonNull KeycloakProperties properties) {
        return KeycloakBuilder.builder()
                .serverUrl(properties.getServerUrl().toString())
                .realm(properties.getRealm())
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .clientId(properties.getClient().getId())
                .clientSecret(properties.getClient().getSecret())
                .username(properties.getClient().getUsername())
                .password(properties.getClient().getPassword())
                .build();
    }
}
