package com.chaffee.service;

import com.chaffee.entity.pojo.GoodDetails;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chaffee.entity.vo.GoodDetailVO;

/**
* @author RGB
* @description 针对表【good_details】的数据库操作Service
* @createDate 2022-05-25 16:32:43
*/
public interface GoodDetailsService extends IService<GoodDetails> {

  GoodDetailVO queryOneById(Long id);
}
