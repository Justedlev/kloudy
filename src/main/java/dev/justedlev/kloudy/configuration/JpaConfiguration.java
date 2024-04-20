package dev.justedlev.kloudy.configuration;

import dev.justedlev.common.AuthAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaConfiguration {
    @Bean
    AuditorAware<String> auditorAware() {
        return new AuthAuditorAware();
    }
}
