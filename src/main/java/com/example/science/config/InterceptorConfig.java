package com.example.science.config;

import com.example.science.security.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(JwtInterceptor())
                .addPathPatterns("/**")  // 拦截所有请求，判断token是否合法
                .excludePathPatterns("/**/login","/**/register");  //放行请求
    }

    @Bean
    public JwtInterceptor JwtInterceptor(){
        return new JwtInterceptor();
    }
}
