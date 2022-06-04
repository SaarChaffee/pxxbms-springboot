/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/1
 */
package com.chaffee.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class PXXMvcConfig implements WebMvcConfigurer {
  
  @Value( "${file.resourcePath}" )
  private String resourcePath;
  @Value( "${file.uploadPath}" )
  private String resourceFolder;
  
  @Override
  public void addResourceHandlers( ResourceHandlerRegistry registry ) {
    registry.addResourceHandler( resourcePath+"/**" ).addResourceLocations("file:"+ resourceFolder+"/" );
  }
  
  @Override
  public void addCorsMappings( CorsRegistry registry ) {
    registry.addMapping( "/**" );
  }
  
  @Override
  public void addViewControllers( ViewControllerRegistry registry ) {
    registry.addViewController( "/" ).setViewName( "index" );
    registry.addViewController( "/index.html" ).setViewName( "index" );
    registry.addViewController( "/main.html" ).setViewName( "dashboard" );
  }
  
  @Override
  public void extendMessageConverters( List<HttpMessageConverter<?>> converters ) {
    MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
    ObjectMapper objectMapper = jackson2HttpMessageConverter.getObjectMapper();
    
    SimpleModule simpleModule = new SimpleModule();
    //将Long转为string 解决id过大 js显示问题
    simpleModule.addSerializer( Long.class, ToStringSerializer.instance );
    simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
    //simpleModule.addSerializer( Date.class,ToStringSerializer.instance );
    objectMapper.registerModule(simpleModule);
    
    jackson2HttpMessageConverter.setObjectMapper(objectMapper);
    //放到第一个
    converters.add(0, jackson2HttpMessageConverter);
  }
  
  @Bean
  public LocaleResolver localeResolver() {
    return new PXXLocaleResolver();
  }
}
