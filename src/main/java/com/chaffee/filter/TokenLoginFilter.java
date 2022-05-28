/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/25
 */
package com.chaffee.filter;

import com.chaffee.util.JwtTokenUtil;
import com.chaffee.util.R;
import com.chaffee.util.ResponseUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {
  
  private AuthenticationManager authenticationManager;
  
  public TokenLoginFilter( AuthenticationManager authenticationManager ) {
    this.authenticationManager = authenticationManager;
    this.setPostOnly( false );
    this.setRequiresAuthenticationRequestMatcher( new AntPathRequestMatcher( "/login", "POST" ) );
  }
  
  
  @Override
  public Authentication attemptAuthentication( HttpServletRequest request, HttpServletResponse response ) throws AuthenticationException {
    try{
      String username = request.getParameter( "username" );
      String password = request.getParameter( "password" );
      username = username != null ? username.trim() : "";
      password = password != null ? password : "";
      return authenticationManager.authenticate( new UsernamePasswordAuthenticationToken( username, password,
                                                                                          new ArrayList<>() ) );
    }catch( Exception e ){
      throw new RuntimeException( e );
    }
  }
  
  @Override
  protected void successfulAuthentication( HttpServletRequest request, HttpServletResponse response,
                                           FilterChain chain, Authentication authResult ) throws IOException,
      ServletException {
    User user = ( User ) authResult.getPrincipal();
    String authrorities = user.getAuthorities().size() > 0 ? user.getAuthorities().toString().replaceAll(
        "(?:\\[|null|\\]| +)", "" ) : user.getAuthorities().toString();
    
    String token = JwtTokenUtil.createToken( user.getUsername(), authrorities );
    HashMap<Object, Object> map = new HashMap<>();
    map.put( "token", token );
    response.setHeader( "Access-Control-Allow-Origin","*" );
    ResponseUtil.out( response, R.ok().datas( map ) );
  }
  
  @Override
  protected void unsuccessfulAuthentication( HttpServletRequest request, HttpServletResponse response,
                                             AuthenticationException failed ) throws IOException, ServletException {
    ResponseUtil.out( response, R.error().message( "登录失败" ) );
  }
}
