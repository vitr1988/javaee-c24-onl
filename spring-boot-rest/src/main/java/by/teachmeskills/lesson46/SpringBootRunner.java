package by.teachmeskills.lesson46;

import by.teachmeskills.lesson46.config.LiquibaseProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class SpringBootRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootRunner.class, args);
        LiquibaseProperties liquibaseProperties = run.getBean(LiquibaseProperties.class);
        Resource changeLog = liquibaseProperties.getChangeLog();
    }
}
