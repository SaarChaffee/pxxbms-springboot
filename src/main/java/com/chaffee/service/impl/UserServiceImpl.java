package com.chaffee.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaffee.entity.dto.LoginDTO;
import com.chaffee.entity.pojo.User;
import com.chaffee.entity.vo.UserVO;
import com.chaffee.mapper.UserMapper;
import com.chaffee.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RGB
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2022-04-30 10:31:55
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {
  LoginDTO login = null;
  
  @Override
  public LoginDTO queryLogin( String userCode, String passWord ) {
    if( !StringUtils.isEmpty( userCode ) && !StringUtils.isEmpty( passWord ) ){
      login = baseMapper.queryLogin( userCode );
      if( login != null && StringUtils.equals( passWord, login.getUserPassword() ) ){
        return login;
      }
    }
    return null;
  }
  
  @Override
  public List<UserVO> queryUserList( IPage<UserVO> page, String userName, int userRole ) {
    return baseMapper.queryUserList( page, userName, userRole );
  }
}




