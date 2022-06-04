/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/5
 */
package com.chaffee.config;

import com.chaffee.filter.TokenAuthenticationFilter;
import com.chaffee.filter.TokenLoginFilter;
import com.chaffee.handler.LogoutSuccessHandler;
import com.chaffee.handler.UnauthorizedEntryPoint;
import com.chaffee.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  SecurityService securityService;
  
  @Override
  protected void configure( HttpSecurity http ) throws Exception {
    
    http.exceptionHandling()
        .authenticationEntryPoint( new UnauthorizedEntryPoint() )
        .and()
        .cors()
        //.and()
        //.headers().contentTypeOptions().disable()
        .and()
        .authorizeRequests()
        //.antMatchers( "/index**", "/swagger-ui/**", "/swagger-resources/**", "/v3/api-docs",
        //              "configuration/ui", "configuration/security", "/webjars/**" )
        //.permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .csrf().disable()
        .logout().logoutUrl( "/user/logout" ).logoutSuccessHandler( new LogoutSuccessHandler() )
        .and()
        .addFilter( new TokenLoginFilter( authenticationManager() ) )
        .addFilter( new TokenAuthenticationFilter( authenticationManager() ) );
  }
  
  @Override
  protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
    auth.userDetailsService( securityService ).passwordEncoder( new PasswordEncoderConfig() );
  }
  
  @Override
  public void configure( WebSecurity web ) throws Exception {
    web.ignoring()
        .antMatchers( "/index**"  )
        .antMatchers( "/swagger-ui/**" )
        .antMatchers( "/swagger-resources/**")
        .antMatchers("/v3/api-docs")
        .antMatchers("configuration/ui")
        .antMatchers("configuration/security")
        .antMatchers("/webjars/**")
        .antMatchers( "/resource/**" );
  }
  
  
}
