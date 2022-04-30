package com.chaffee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaffee.entity.pojo.Good;
import com.chaffee.service.GoodService;
import com.chaffee.mapper.GoodMapper;
import org.springframework.stereotype.Service;

/**
* @author RGB
* @description 针对表【good】的数据库操作Service实现
* @createDate 2022-04-30 10:31:55
*/
@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good>
    implements GoodService{

}




