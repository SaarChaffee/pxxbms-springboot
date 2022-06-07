package com.chaffee.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaffee.entity.dto.LoginDTO;
import com.chaffee.entity.dto.UserCodeDTO;
import com.chaffee.entity.pojo.Good;
import com.chaffee.entity.pojo.User;
import com.chaffee.entity.pojo.UserAvatar;
import com.chaffee.entity.vo.ProfileVO;
import com.chaffee.entity.vo.UserAvatarVO;
import com.chaffee.entity.vo.UserVO;
import com.chaffee.mapper.UserMapper;
import com.chaffee.service.BillService;
import com.chaffee.service.GoodService;
import com.chaffee.service.UserAvatarService;
import com.chaffee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
  @Autowired
  BillService billService;
  @Autowired
  GoodService goodService;
  
  @Autowired
  UserAvatarService userAvatarService;
  @Override
  public LoginDTO queryLogin( String userCode ) {
    LoginDTO login = null;
    if( !StringUtils.isEmpty( userCode ) ){
      login = baseMapper.queryLogin( userCode );
      if( login != null ){
        login.setAvatar( userAvatarService.getById( login.getId() ).getAvatar() );
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
  
  @Override
  public boolean remove( Long id ) {
    QueryWrapper<Good> goodWrapper = new QueryWrapper<>();
    goodWrapper.eq( "owner",id );
    long count = goodService.count( goodWrapper );
    boolean result = false;
    if( count==0 ){
      result = this.removeById( id );
    }
    return result;
  }
  
  
}




