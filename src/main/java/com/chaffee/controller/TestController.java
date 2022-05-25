/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/5
 */
package com.chaffee.controller;

import com.chaffee.entity.dto.UserCodeDTO;
import com.chaffee.service.UserRoleService;
import com.chaffee.service.UserService;
import com.chaffee.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/test")
public class TestController {
  @Autowired
  UserService userService;
  @Autowired
  UserRoleService userRoleService;
  
  @GetMapping("/query/{name}")
  public R queryAll( @PathVariable("name")String name ){
    UserCodeDTO userCodeDTO = userService.queryUserByCode( name );
    return R.ok().data( userCodeDTO );
  }
}
