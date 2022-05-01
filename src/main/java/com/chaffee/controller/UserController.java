/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/1
 */
package com.chaffee.controller;

import com.chaffee.entity.dto.LoginDTO;
import com.chaffee.service.UserService;
import com.chaffee.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping( "/user" )
public class UserController {
  @Autowired
  UserService userService;
  
  @RequestMapping( "/login" )
  public String login( @RequestParam String username, @RequestParam( "userpasswd" ) String password, @RequestParam(
      value = "remember-me", required = false ) Boolean remember, Model model,
                       HttpSession session ) {
    LoginDTO login = userService.queryLogin( username, password );
    System.out.println( remember );
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
}
