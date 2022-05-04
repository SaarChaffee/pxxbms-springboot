package com.chaffee.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chaffee.entity.dto.GoodCodeDTO;
import com.chaffee.entity.pojo.Good;
import com.chaffee.entity.vo.GoodVO;

import java.util.List;

/**
 * @author RGB
 * @description 针对表【good】的数据库操作Service
 * @createDate 2022-04-30 10:31:55
 */
public interface GoodService extends IService<Good> {
  List<GoodVO> queryGoodList( IPage<GoodVO> page, String goodName, String ownerName, int goodType );
  
  GoodVO queryGood( long id );
  
  GoodCodeDTO queryGoodByCode( String goodCode );
}
