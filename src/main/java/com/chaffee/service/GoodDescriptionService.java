package com.chaffee.service;

import com.chaffee.entity.pojo.GoodDescription;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chaffee.entity.vo.GoodDescriptionVO;

/**
* @author RGB
* @description 针对表【good_description】的数据库操作Service
* @createDate 2022-05-25 16:32:43
*/
public interface GoodDescriptionService extends IService<GoodDescription> {
  GoodDescriptionVO queryOneById( Long id );
  
}
