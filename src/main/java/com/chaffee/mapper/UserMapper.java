package com.chaffee.mapper;

import com.chaffee.entity.dto.LoginDTO;
import com.chaffee.entity.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author RGB
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-04-30 10:31:55
* @Entity User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
  public LoginDTO queryLogin(@Param( "userCode" ) String userCode );
}




