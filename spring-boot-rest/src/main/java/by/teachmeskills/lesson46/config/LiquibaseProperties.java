package by.teachmeskills.lesson46.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.liquibase")
public class LiquibaseProperties {
    private Resource changeLog;
}
