package dev.justedlev.kloudy.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.file.Path;

@Getter
@Setter
@ConfigurationProperties(prefix = "kloudy")
public class KloudyProperties {
    private Path rootPath;
    private String downloadFilename;
}
