package com.emall.emalldeskfronton.config;

import com.emall.emallweb.intercepter.UserIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfigAdapter implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor userIntercepter() {
        return new UserIntercepter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userIntercepter());
    }

}
