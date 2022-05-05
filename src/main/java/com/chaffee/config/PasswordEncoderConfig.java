/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/5
 */
package com.chaffee.config;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderConfig implements PasswordEncoder {
  
  @Override
  public String encode( CharSequence rawPassword ) {
    return rawPassword.toString();
  }
  
  @Override
  public boolean matches( CharSequence rawPassword, String encodedPassword ) {
    return encodedPassword.equals( rawPassword.toString() );
  }
}
