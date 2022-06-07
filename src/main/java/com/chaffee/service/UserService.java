package com.chaffee.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chaffee.entity.dto.LoginDTO;
import com.chaffee.entity.dto.UserCodeDTO;
import com.chaffee.entity.pojo.User;
import com.chaffee.entity.vo.ProfileVO;
import com.chaffee.entity.vo.UserVO;

import java.util.List;

/**
 * @author RGB
 * @description 针对表【user】的数据库操作Service
 * @createDate 2022-04-30 10:31:55
 */
public interface UserService extends IService<User> {
  
  LoginDTO queryLogin( String userCode);
  
  List<UserVO> queryUserList( IPage<UserVO> page, String userName, long userRole );
  
  UserVO queryUser( Long id );
  
  UserCodeDTO queryUserByCode( String userCode );
  
  boolean remove(Long id);
  
  ProfileVO getProfile(Long id);
  
  boolean judgePasswd(String passwd, Long id);
  
  boolean updatePasswd(String passwd, Long id);
}
