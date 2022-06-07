package com.chaffee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaffee.entity.pojo.UserAvatar;
import com.chaffee.service.UserAvatarService;
import com.chaffee.mapper.UserAvatarMapper;
import org.springframework.stereotype.Service;

/**
* @author RGB
* @description 针对表【user_avatar】的数据库操作Service实现
* @createDate 2022-06-07 14:36:58
*/
@Service
public class UserAvatarServiceImpl extends ServiceImpl<UserAvatarMapper, UserAvatar>
    implements UserAvatarService{

}




