package dev.justedlev.kloudy.configuration.security;

import dev.justedlev.kloudy.configuration.properties.KeycloakJwtConverterProperties;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class KeycloakJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    private final KeycloakJwtConverterProperties properties;
    private final KeycloakGrantedAuthoritiesConverter keycloakGrantedAuthoritiesConverter;

    @Override
    public AbstractAuthenticationToken convert(@NonNull Jwt jwt) {
        var name = extractName(jwt);
        var authorities = keycloakGrantedAuthoritiesConverter.convert(jwt);

        return new JwtAuthenticationToken(jwt, authorities, name);
    }

    private String extractName(@NonNull Jwt jwt) {
        return Optional.of(properties)
                .map(KeycloakJwtConverterProperties::getUsernameAttribute)
                .map(jwt::getClaimAsString)
                .orElseGet(jwt::getSubject);
    }
}
