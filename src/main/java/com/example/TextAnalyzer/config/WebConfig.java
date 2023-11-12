package com.example.TextAnalyzer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // This allows all endpoints in your app
                .allowedOrigins("http://localhost:4200") // This is the domain of your Angular app
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Whatever methods you want to allow
                .allowedHeaders("*"); // Allows all headers
    }
}