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
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;

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
        .apis( RequestHandlerSelectors.any() )
        .build()
        .securityContexts( List.of( securityContext() ) )
        .securitySchemes( List.of( new ApiKey( "token", "token", "header" ) ) );
  }
  
  private SecurityContext securityContext() {
    return SecurityContext.builder()
        .securityReferences( defaultAuth() )
        //.forPaths(PathSelectors.regex("/*.*"))
        .build();
  }
  
  private List<SecurityReference> defaultAuth() {
    AuthorizationScope authorizationScope
        = new AuthorizationScope( "global", "accessEverything" );
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;
    return singletonList(
        new SecurityReference( "token", authorizationScopes ) );
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
