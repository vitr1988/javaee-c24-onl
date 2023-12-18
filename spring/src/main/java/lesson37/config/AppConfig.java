package lesson37.config;

import lesson37.dao.ReportDao;
import lesson37.dao.impl.ReportJpaDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@PropertySources(
        {
                @PropertySource("classpath:resource.properties"),
                @PropertySource("classpath:app.properties")
        }
)
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("lesson37")
public class AppConfig {

    @Bean
//    @Qualifier("reportJpaDao")
    @Primary
    ReportDao reportJpaDao() {
        return new ReportJpaDao();
    }


//    @Bean
//    String helloWorld() {
//        return "Hello world";
//    }
}
