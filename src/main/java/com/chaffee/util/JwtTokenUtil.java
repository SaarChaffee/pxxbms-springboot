/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/25
 */
package com.chaffee.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtTokenUtil {
  
  
  public static String createToken( String userName ) {
    String token = Jwts.builder()
        .setSubject( userName )
        .setExpiration( new Date( System.currentTimeMillis() + Constants.TokenExpiration ) )
        .signWith( SignatureAlgorithm.HS256, Constants.TokenSignkey )
        .compressWith( CompressionCodecs.GZIP ).compact();
    return token;
  }
  
  public static String createToken( String userName, String role ) {
    String token = Jwts.builder()
        .setSubject( userName )
        .claim( Constants.UserRoleKey, role )
        .setExpiration( new Date( System.currentTimeMillis() + Constants.TokenExpiration ) )
        .signWith( SignatureAlgorithm.HS256, Constants.TokenSignkey )
        .compressWith( CompressionCodecs.GZIP ).compact();
    return token;
  }
  
  public static String getUserNameFromToken( String token ) {
    String name = Jwts.parser()
        .setSigningKey( Constants.TokenSignkey )
        .parseClaimsJws( token )
        .getBody().getSubject();
    return name;
  }
  
  public static String getUserRoleFromToken( String token ) {
    Claims claims = Jwts.parser()
        .setSigningKey( Constants.TokenSignkey )
        .parseClaimsJws( token )
        .getBody();
    return claims.get( Constants.UserRoleKey ).toString();
  }
}
