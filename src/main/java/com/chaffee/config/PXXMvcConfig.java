/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/1
 */
package com.chaffee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PXXMvcConfig implements WebMvcConfigurer {
  
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
  
  @Bean
  public LocaleResolver localeResolver() {
    return new PXXLocaleResolver();
  }
}
