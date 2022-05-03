package com.chaffee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chaffee.entity.dto.LoginDTO;
import com.chaffee.entity.dto.UserCodeDTO;
import com.chaffee.entity.pojo.User;
import com.chaffee.entity.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author RGB
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2022-04-30 10:31:55
 * @Entity User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
  LoginDTO queryLogin( @Param( "userCode" ) String userCode );
  
  List<UserVO> queryUserList( @Param( "page" ) IPage<UserVO> page, @Param( "userName" ) String userName, @Param(
      "userRole" ) int userRole );
  
  UserVO queryUser(@Param( "id" )long id);
  
  UserCodeDTO queryUserByCode(@Param( "userCode" )String userCode);
}




