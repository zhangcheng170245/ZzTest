package com.zztest.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @Author: zhangcheng
 * @Description:
 * @Date: 2021/3/24/024 12:00
 * @Version: 1.0
 */
@Configuration  //注射为springboot 配置类
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    public DemoInterceptor demoInterceptor;

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(demoInterceptor).addPathPatterns("/**")//所有目录
           //  .excludePathPatterns("","")
        ; }

     //配置信息
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(messageConverter());
    }

    @Bean
    public HttpMessageConverter<String>  messageConverter(){
        return  new StringHttpMessageConverter(Charset.forName("utf-8"));
    }


// 配置静态资源
 /*   @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }*/
}
