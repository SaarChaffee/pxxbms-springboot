/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/5
 */
package com.chaffee.controller;

import com.chaffee.entity.dto.LoginDTO;
import com.chaffee.service.UserRoleService;
import com.chaffee.service.UserService;
import com.chaffee.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
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
    LoginDTO login = userService.queryLogin( username);
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
}
