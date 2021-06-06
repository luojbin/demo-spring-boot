package com.luojbin.demo.spring.boot.parent.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ApiInterceptor())
                .addPathPatterns("/customer/**")
                .addPathPatterns("/gateway/**")
                .addPathPatterns("/system/**");
    }
}
