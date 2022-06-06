package com.chaffee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaffee.entity.pojo.Good;
import com.chaffee.entity.pojo.GoodType;
import com.chaffee.service.GoodService;
import com.chaffee.service.GoodTypeService;
import com.chaffee.mapper.GoodTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author RGB
* @description 针对表【good_type】的数据库操作Service实现
* @createDate 2022-04-30 10:31:55
*/
@Service
public class GoodTypeServiceImpl extends ServiceImpl<GoodTypeMapper, GoodType>
    implements GoodTypeService{
  @Autowired
  GoodService goodService;
  @Override
  public boolean remove( Long id ) {
    QueryWrapper<Good> wrapper = new QueryWrapper<>();
    wrapper.eq( "goodType",id );
    long count = goodService.count( wrapper );
    boolean result = false;
    if( count == 0 ){
      result = this.removeById( id );
    }
    return result;
  }
}
