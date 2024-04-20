package dev.justedlev.kloudy.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

@Setter
@Getter
@ConfigurationProperties(prefix = "keycloak.jwt-converter")
public class KeycloakJwtConverterProperties {
    private Set<String> roleClaims;
    private String usernameAttribute;
}
