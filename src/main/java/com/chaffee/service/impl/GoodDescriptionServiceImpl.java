package com.chaffee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaffee.entity.pojo.GoodDescription;
import com.chaffee.entity.vo.GoodDescriptionVO;
import com.chaffee.service.GoodDescriptionService;
import com.chaffee.mapper.GoodDescriptionMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
* @author RGB
* @description 针对表【good_description】的数据库操作Service实现
* @createDate 2022-05-25 16:32:43
*/
@Service
public class GoodDescriptionServiceImpl extends ServiceImpl<GoodDescriptionMapper, GoodDescription>
    implements GoodDescriptionService{
  @Override
  public GoodDescriptionVO queryOneById( Long id ) {
    GoodDescriptionVO vo = new GoodDescriptionVO();
    BeanUtils.copyProperties( baseMapper.selectById( id ),vo );
    return vo;
  }
}




