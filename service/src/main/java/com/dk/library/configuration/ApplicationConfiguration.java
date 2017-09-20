package com.dk.library.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.List;


@Configuration
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters)
    {
        converters.clear();
        converters.addAll(Arrays.asList(new CustomJsonHttpMessageConverter(),
                                        new ByteArrayHttpMessageConverter(),
                                        new StringHttpMessageConverter()));
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController(
                "/library-service/v2/api-docs", "/v2/api-docs");
        registry.addRedirectViewController(
                "/library-service/configuration/ui",
                "/configuration/ui");
        registry.addRedirectViewController(
                "/library-service/swagger-resources",
                "/swagger-resources");
        registry.addRedirectViewController("/library-service",
                                           "/swagger-ui.html");
        registry.addRedirectViewController("/library-service/",
                                           "/swagger-ui.html");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/library-service/**").addResourceLocations(
                "classpath:/META-INF/resources/");
    }
}
