package com.chaffee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan( "com.chaffee.mapper" )
public class PxxbmsSpringbootApplication {
  
  public static void main( String[] args ) {
    SpringApplication.run( PxxbmsSpringbootApplication.class, args );
  }
  
}
