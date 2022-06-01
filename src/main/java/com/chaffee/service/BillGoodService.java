package com.chaffee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chaffee.entity.pojo.BillGood;
import com.chaffee.entity.vo.BillGoodVO;

import java.util.List;

/**
* @author RGB
* @description 针对表【bill_good】的数据库操作Service
* @createDate 2022-05-31 10:49:37
*/
public interface BillGoodService extends IService<BillGood> {

  List<BillGoodVO> queryListByBillId( Long id );
}
