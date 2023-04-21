package com.example.Litres.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * \brief Система авторизации
 * \details Класс, содержащий конфигурацию веб-слоя для системы авторизации.
 */
@Configuration
public class SecurityConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

}