package com.chaffee.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaffee.entity.dto.LoginDTO;
import com.chaffee.entity.dto.UserCodeDTO;
import com.chaffee.entity.pojo.User;
import com.chaffee.entity.vo.UserVO;
import com.chaffee.mapper.UserMapper;
import com.chaffee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author RGB
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2022-04-30 10:31:55
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {
  @Autowired
  HttpSession session;
  @Override
  public LoginDTO queryLogin( String userCode ) {
    LoginDTO login = null;
    if( !StringUtils.isEmpty( userCode ) ){
      login = baseMapper.queryLogin( userCode );
      if( login != null ){
        return login;
      }
    }
    return null;
  }
  
  @Override
  public List<UserVO> queryUserList( IPage<UserVO> page, String userName, long userRole ) {
    return baseMapper.queryUserList( page, userName, userRole );
  }
  
  @Override
  public UserVO queryUser( Long id ) {
    return baseMapper.queryUser( id );
  }
  
  @Override
  public UserCodeDTO queryUserByCode( String userCode ) {
    return baseMapper.queryUserByCode( userCode );
  }
  

}




