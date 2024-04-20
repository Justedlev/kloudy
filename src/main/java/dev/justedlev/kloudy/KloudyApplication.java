package dev.justedlev.kloudy;

import dev.justedlev.kloudy.configuration.properties.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties({
		KloudyProperties.class,
		SecurityProperties.class,
		KeycloakProperties.class,
		KeycloakUserProperties.class,
		KeycloakProperties.class,
		KeycloakJwtConverterProperties.class,
		KeycloakClientProperties.class,
})
public class KloudyApplication {
	public static void main(String[] args) {
		SpringApplication.run(KloudyApplication.class, args);
	}
}
