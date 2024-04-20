package dev.justedlev.kloudy.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

@Getter
@Setter
@ConfigurationProperties("security")
public class SecurityProperties {
    private Set<String> whiteList;
}
