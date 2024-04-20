package dev.justedlev.kloudy.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Setter
@Getter
@ConfigurationProperties(prefix = "keycloak.user")
public class KeycloakUserProperties {
    private List<String> groups;
}
