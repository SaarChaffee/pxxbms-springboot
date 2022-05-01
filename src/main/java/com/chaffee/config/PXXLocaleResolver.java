/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/1
 */
package com.chaffee.config;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Component
public class PXXLocaleResolver implements LocaleResolver {
  @Override
  public Locale resolveLocale( HttpServletRequest request ) {
    String language = request.getParameter( "lang" );
    Locale locale = Locale.getDefault();
    if( StringUtils.hasLength( language ) ){
      String[] split = language.split( "_" );
      locale = new Locale( split[0], split[1] );
    }
    return locale;
  }
  
  @Override
  public void setLocale( HttpServletRequest request, HttpServletResponse response, Locale locale ) {
  
  }
}
