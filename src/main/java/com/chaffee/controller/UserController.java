/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/1
 */
package com.chaffee.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaffee.entity.dto.LoginDTO;
import com.chaffee.entity.pojo.UserRole;
import com.chaffee.entity.vo.UserVO;
import com.chaffee.service.UserRoleService;
import com.chaffee.service.UserService;
import com.chaffee.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping( "/user" )
public class UserController {
  @Autowired
  UserService userService;
  @Autowired
  UserRoleService userRoleService;
  
  @RequestMapping( "/login" )
  public String login( @RequestParam String username,
                       @RequestParam( "userpasswd" ) String password,
                       @RequestParam( value = "remember-me", required = false ) Boolean remember,
                       Model model,
                       HttpSession session ) {
    LoginDTO login = userService.queryLogin( username, password );
    if( login != null ){
      session.setAttribute( Constants.USER_SESSION, login );
      return "redirect:/main.html";
    }
    else{
      model.addAttribute( Constants.MSG, "用户信息错误，请重新输入" );
      return "index";
    }
  }
  
  @RequestMapping( "/logout" )
  public String logout( HttpSession session ) {
    session.invalidate();
    return "redirect:/index.html";
  }
  
  @RequestMapping( "/list" )
  public String list( @RequestParam( value = "queryUserName", required = false ) String userName,
                      @RequestParam( value = "queryUserRole", required = false ) String role,
                      @RequestParam( value = "pageIndex", required = false ) String pageIndex,
                      Model model ) {
    userName = StringUtils.isEmpty( userName ) ? "" : userName;
    int userRole = StringUtils.isNumber( role ) && !role.contains( "-" ) ? Integer.parseInt( role ) : 0;
    int index = StringUtils.isNumber( pageIndex ) && !role.contains( "-" ) ? Integer.parseInt( pageIndex ) : 1;
    
    Page<UserVO> page = new Page<>( index, 15 );
    List<UserVO> userList = userService.queryUserList( page, userName, userRole );
    System.out.println(page.getPages());
    List<UserRole> roleList = userRoleService.list();
    model.addAttribute( "users", userList );
    model.addAttribute( "pageParam", page );
    model.addAttribute( "roleList", roleList );
    model.addAttribute( "queryUserName", userName );
    model.addAttribute( "queryUserRole", userRole );
    model.addAttribute( "pageIndex", index );
    return "user/list";
  }
}
