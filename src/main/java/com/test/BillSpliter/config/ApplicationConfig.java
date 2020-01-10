package com.test.BillSpliter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


import javax.xml.ws.spi.WebServiceFeatureAnnotation;

@Configuration
@ComponentScan(basePackages="com.test.BillSpliter")
public class ApplicationConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("css/**","img/**","js/**","scss/**","vendor/**")
                .addResourceLocations("classpath:/static/css/","classpath:/static/img/","classpath:/static/js/","classpath:/static/scss/","classpath:/static/vendor/");

    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

}
