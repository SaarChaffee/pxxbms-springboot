/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/5
 */
package com.chaffee.config;

import com.chaffee.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  SecurityService securityService;
  
  @Override
  protected void configure( HttpSecurity http ) throws Exception {
    
    http.authorizeRequests()
        .antMatchers( "/", "/index.html" ).permitAll()
        .antMatchers( "/login" ).permitAll()
        .antMatchers( "/*" ).authenticated()
        .antMatchers( "/user/*" ).hasRole( "1" )
        .antMatchers( "/user/list/*" ).permitAll();
    
    
    http.formLogin()
        .usernameParameter( "username" )
        .passwordParameter( "userpasswd" )
        .loginPage( "/" )
        .loginProcessingUrl( "/login" )
        .defaultSuccessUrl( "/main.html" );
    http.rememberMe().rememberMeParameter( "remember" );
    http.csrf().disable();
    http.logout().logoutSuccessUrl( "/" );
  }
  
  @Override
  protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
    auth.userDetailsService( securityService ).passwordEncoder( new PasswordEncoderConfig() );
  }
  
  
}
