package by.teachmeskills.lesson39;

import by.teachmeskills.lesson39.logging.LogInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@RequiredArgsConstructor
@ComponentScan//("by.teachmeskills.lesson39")
public class WebConfig implements WebMvcConfigurer {

    @Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setPrefix("/pages/"); // /pages/{page}.jsp
        return internalResourceViewResolver;
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor());
    }

    @Bean
    HandlerInterceptor logInterceptor() {
        return new LogInterceptor();
    }
}
