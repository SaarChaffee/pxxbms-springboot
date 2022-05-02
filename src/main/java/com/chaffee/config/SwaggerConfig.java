/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/2
 */
package com.chaffee.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
  
  @Value( "${swagger2.enable}" )
  private boolean enableDocket;
  
  @Bean
  public Docket docket() {
    return new Docket( DocumentationType.OAS_30 )
        .apiInfo( apiInfo() )
        .enable( enableDocket )
        .groupName( "Chaffee" )
        .select()
        //RequestHandlerSelectors，配置要扫描的方式
        .apis( RequestHandlerSelectors.any() )
        //.apis( RequestHandlerSelectors.basePackage( "com.chaffee" ) )
        //path：指定路径
        //ant()：只扫描指定路径
        //.paths( PathSelectors.ant( "/chaffee/**" ) )
        .build();
  }
  
  //配置
  private ApiInfo apiInfo() {
    return new ApiInfo( "Swagger控制台",
                        "Swagger控制台",
                        "114514",
                        "https://github.com/SaarChaffee",
                        new Contact( "SaarChaffee", "https://github.com/SaarChaffee", "1240148332@qq.com" ),
                        "MIT",
                        "https://mit-license.org/",
                        new ArrayList() );
    
  }
}
