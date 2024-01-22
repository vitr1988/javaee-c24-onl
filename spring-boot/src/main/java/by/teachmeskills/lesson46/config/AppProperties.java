package by.teachmeskills.lesson46.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private Setting setting;

    @Data
    public static class Setting {
        private Long age;
        private String name;
    }
}
