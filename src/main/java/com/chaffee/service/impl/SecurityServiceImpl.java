/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/5
 */
package com.chaffee.service.impl;

import com.chaffee.entity.dto.LoginDTO;
import com.chaffee.entity.pojo.UserRole;
import com.chaffee.service.SecurityService;
import com.chaffee.service.UserRoleService;
import com.chaffee.service.UserService;
import com.chaffee.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class SecurityServiceImpl implements SecurityService {
  
  @Autowired
  UserService userService;
  @Autowired
  UserRoleService userRoleService;
  @Autowired
  HttpSession session;
  
  @Override
  public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
    
    LoginDTO loginDTO = userService.queryLogin( username );
    UserDetails userDetails = null;
    if( loginDTO != null ){
      session.setAttribute( Constants.USER_SESSION, loginDTO );
      String passwd = loginDTO.getUserPassword();
      userDetails = new User( username,
                              passwd,
                              true,
                              true,
                              true,
                              true,
                              getAuthorities( loginDTO ) );
    }
    return userDetails;
  }
  
  private Collection<GrantedAuthority> getAuthorities( LoginDTO user ) {
    List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
    UserRole role = userRoleService.getById( user.getUserRole() );
    //注意：这里每个权限前面都要加ROLE_。否在最后验证不会通过
    authList.add( new SimpleGrantedAuthority( "ROLE_" + role.getId() ) );
    return authList;
  }
}
