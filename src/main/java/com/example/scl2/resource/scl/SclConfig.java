package com.example.scl2.resource.scl;


import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SclConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/*") // Defina o padrão de URL que deseja permitir
                .allowedOrigins(" ") // Defina a origem permitida (ou "" para permitir todas)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Defina os métodos HTTP permitidos
                .allowedHeaders(""); // Defina os cabeçalhos permitidos (ou "" para permitir todos)
    }
}
