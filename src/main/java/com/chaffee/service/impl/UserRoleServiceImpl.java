package com.chaffee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaffee.entity.pojo.UserRole;
import com.chaffee.service.UserRoleService;
import com.chaffee.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author RGB
* @description 针对表【user_role】的数据库操作Service实现
* @createDate 2022-04-30 10:31:55
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




