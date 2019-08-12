package com.onecredit.sikapa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("auth/login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/settings").setViewName("settings");
        registry.addViewController("/reports").setViewName("reports");
        registry.addViewController("/profile").setViewName("profile");

    }


}