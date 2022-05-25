package com.chaffee;

import com.chaffee.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PxxbmsSpringbootApplicationTests {
  @Autowired
  UserMapper mapper;
  @Test
  void contextLoads() {
    System.out.println( mapper.queryLogin( "admin" ) );
  }
  
}
