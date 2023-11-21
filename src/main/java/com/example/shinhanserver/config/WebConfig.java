package com.example.shinhanserver.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000", "http://133.186.218.115", "http://133.186.153.215")
                .allowedMethods("GET", "POST")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
