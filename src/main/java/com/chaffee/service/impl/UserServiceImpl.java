package com.chaffee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaffee.entity.pojo.User;
import com.chaffee.service.UserService;
import com.chaffee.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author RGB
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-04-30 10:31:55
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




