package com.example.science.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 跨域访问配置类
 * https://blog.csdn.net/qq_18671415/article/details/109275495?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522163092178316780366598367%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=163092178316780366598367&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-1-109275495.pc_search_es_clickV2&utm_term=%40CrossOrigin&spm=1018.2226.3001.4187
 */

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    //服务器支持跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")   //设置访问源地址
                .allowedMethods("*")   //设置访问源请求头
                .allowedHeaders("*")   //设置访问源请求方法
                .exposedHeaders("Access-Control-Allow-Headers",
                        "Access-Control-Allow-Methods",
                        "Access-Control-Allow-Origin",
                        "Access-Control-Max-Age",
                        "X-Frame-Options",
                        "Authorization",
                        "TokenType")
                .allowCredentials(false)
                .maxAge(3600);
    }
}
