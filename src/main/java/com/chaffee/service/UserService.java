package com.chaffee.service;

import com.chaffee.entity.dto.LoginDTO;
import com.chaffee.entity.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author RGB
* @description 针对表【user】的数据库操作Service
* @createDate 2022-04-30 10:31:55
*/
public interface UserService extends IService<User> {
  
  LoginDTO queryLogin(String userCode,String passWord);
  
}
