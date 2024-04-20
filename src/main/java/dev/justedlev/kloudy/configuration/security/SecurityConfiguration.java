package dev.justedlev.kloudy.configuration.security;

import dev.justedlev.kloudy.configuration.properties.SecurityProperties;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(jsr250Enabled = true)
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final SecurityProperties properties;
    private final KeycloakJwtAuthenticationConverter keycloakJwtAuthenticationConverter;

    @Bean
    public SecurityFilterChain securityFilterChain(@NonNull HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .oauth2ResourceServer(serverSpec -> serverSpec
                        .jwt(jwtConfigurer -> jwtConfigurer
                                .jwtAuthenticationConverter(keycloakJwtAuthenticationConverter)
                        )
                )
                .sessionManagement(sessionManagementConfigurer -> sessionManagementConfigurer
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(requestMatcherRegistry -> requestMatcherRegistry
                        .requestMatchers(properties.getWhiteList().toArray(String[]::new)).permitAll()
                        .requestMatchers(HttpMethod.GET, "/v1/history/accounts/**").hasRole("admin")
                        .requestMatchers(HttpMethod.GET, "/v1/accounts/{}/**").hasAnyAuthority("ROLE_user", "ROLE_admin", "SCOPE_account:read")
                        .requestMatchers(HttpMethod.PATCH, "/v1/accounts/{}/**").hasAnyRole("user", "admin")
                        .requestMatchers(HttpMethod.PUT, "/v1/accounts/{}/**").hasAnyRole("user", "admin")
                        .requestMatchers(HttpMethod.DELETE, "/v1/accounts/{}/**").hasAnyRole("user", "admin")
                        .anyRequest().authenticated()
                )
                .build();
    }

    @Bean
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new NullAuthenticatedSessionStrategy();
    }
}
