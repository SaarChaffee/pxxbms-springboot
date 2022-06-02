package com.chaffee.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaffee.entity.dto.GoodCodeDTO;
import com.chaffee.entity.pojo.Good;
import com.chaffee.entity.vo.GoodVO;
import com.chaffee.service.GoodDescriptionService;
import com.chaffee.service.GoodDetailsService;
import com.chaffee.service.GoodService;
import com.chaffee.mapper.GoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RGB
 * @description 针对表【good】的数据库操作Service实现
 * @createDate 2022-04-30 10:31:55
 */
@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good>
    implements GoodService {
  @Autowired
  GoodDetailsService goodDetailsService;
  @Autowired
  GoodDescriptionService goodDescriptionService;
  
  @Override
  public List<GoodVO> queryGoodList( IPage<GoodVO> page, String goodName, String ownerName, long goodType ) {
    List<GoodVO> goodVOS = baseMapper.queryGoodList( page, goodName, ownerName, goodType );
    goodVOS.forEach( g -> {
      g.setDetail( goodDetailsService.queryOneById( g.getId() ) );
    } );
    return goodVOS;
  }
  
  @Override
  public GoodVO queryGood( long id ) {
    GoodVO vo = baseMapper.queryGood( id );
    vo.setDetail( goodDetailsService.queryOneById( vo.getId() ) );
    vo.setDescription( goodDescriptionService.queryOneById( vo.getId() ) );
    return vo;
  }
  
  @Override
  public GoodCodeDTO queryGoodByCode( String goodCode ) {
    return baseMapper.queryGoodByCode( goodCode );
  }
}




