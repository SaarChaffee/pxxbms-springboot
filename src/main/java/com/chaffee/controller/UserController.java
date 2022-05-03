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
import com.chaffee.entity.dto.UserCodeDTO;
import com.chaffee.entity.pojo.User;
import com.chaffee.entity.pojo.UserRole;
import com.chaffee.entity.vo.UserVO;
import com.chaffee.service.UserRoleService;
import com.chaffee.service.UserService;
import com.chaffee.util.Constants;
import com.chaffee.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping( "/user" )
public class UserController {
  @Autowired
  UserService userService;
  @Autowired
  UserRoleService userRoleService;
  
  @PostMapping( "/login" )
  public String login( @RequestParam( "username" ) String username,
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
  
  @GetMapping( "/logout" )
  public String logout( HttpSession session ) {
    session.invalidate();
    return "redirect:/index.html";
  }
  
  @GetMapping( "/list" )
  public String list( @RequestParam( value = "queryUserName", required = false ) String userName,
                      @RequestParam( value = "queryUserRole", required = false ) String role,
                      @RequestParam( value = "pageIndex", required = false ) String pageIndex,
                      Model model ) {
    userName = StringUtils.isEmpty( userName ) ? "" : userName;
    int userRole = StringUtils.isNumber( role ) && !role.contains( "-" ) ? Integer.parseInt( role ) : 0;
    int index = StringUtils.isNumber( pageIndex ) && !role.contains( "-" ) ? Integer.parseInt( pageIndex ) : 1;
    
    Page<UserVO> page = new Page<>( index, 15 );
    List<UserVO> userList = userService.queryUserList( page, userName, userRole );
    List<UserRole> roleList = userRoleService.list();
    model.addAttribute( "users", userList );
    model.addAttribute( "pageParam", page );
    model.addAttribute( "roleList", roleList );
    model.addAttribute( "queryUserName", userName );
    model.addAttribute( "queryUserRole", userRole );
    return "user/list";
  }
  
  @GetMapping( "/list/{id}" )
  public String list( @PathVariable( "id" ) String userId, Model model ) {
    long id = StringUtils.isNumber( userId ) ? Long.parseLong( userId ) : 0L;
    UserVO userVO = userService.queryUser( id );
    model.addAttribute( "user", userVO );
    return "user/view";
  }
  
  @GetMapping( "/toUpd/{id}" )
  public String toUpd( @PathVariable( "id" ) String userId, Model model ) {
    long id = StringUtils.isNumber( userId ) ? Long.parseLong( userId ) : 0L;
    User user = userService.getById( id );
    List<UserRole> roleList = userRoleService.list();
    model.addAttribute( "user", user );
    model.addAttribute( "roleList", roleList );
    return "user/update";
  }
  
  @PostMapping( "/upd" )
  public String upd( User user ) {
    boolean b = userService.updateById( user );
    return "redirect:/user/list";
  }
  
  @GetMapping( "/toAdd" )
  public String toAdd( Model model ) {
    model.addAttribute( "roleList", userRoleService.list() );
    return "user/add";
  }
  
  @PostMapping( "/add" )
  public String add( User user ) {
    boolean b = userService.save( user );
    return "redirect:/user/list";
  }
  
  @GetMapping( "/exist" )
  @ResponseBody
  private R exist( @RequestParam String userCode ) {
    UserCodeDTO user = userService.queryUserByCode( userCode );
    if( user != null ){
      return R.ok();
    }
    else return R.error();
  }
}
