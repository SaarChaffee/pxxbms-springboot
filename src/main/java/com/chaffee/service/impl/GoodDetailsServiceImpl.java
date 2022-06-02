package com.chaffee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaffee.entity.pojo.GoodDetails;
import com.chaffee.entity.vo.GoodDetailVO;
import com.chaffee.service.GoodDetailsService;
import com.chaffee.mapper.GoodDetailsMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
* @author RGB
* @description 针对表【good_details】的数据库操作Service实现
* @createDate 2022-05-25 16:32:43
*/
@Service
public class GoodDetailsServiceImpl extends ServiceImpl<GoodDetailsMapper, GoodDetails>
    implements GoodDetailsService{
  
  @Override
  public GoodDetailVO queryOneById( Long id ) {
    GoodDetailVO vo = new GoodDetailVO();
    BeanUtils.copyProperties( baseMapper.selectById( id ),vo );
    return vo;
  }
}




