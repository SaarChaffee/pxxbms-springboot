package com.chaffee.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaffee.entity.vo.UserVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/1
 */
@SpringBootTest
class UserMapperTest {
  @Autowired
  UserMapper userMapper;
  
  @Test
  public void getLogin() {
    System.out.println( userMapper.queryLogin( "admin" ) );
  }
  
  @Test
  public void queryUserList() {
    Page<UserVO> page = new Page<>( 2, 4 );
    userMapper.queryUserList( page, "", 0 ).forEach( System.out::println );
  }
}
