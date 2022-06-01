package com.chaffee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaffee.entity.pojo.BillGood;
import com.chaffee.entity.vo.BillGoodVO;
import com.chaffee.service.BillGoodService;
import com.chaffee.mapper.BillGoodMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author RGB
* @description 针对表【bill_good】的数据库操作Service实现
* @createDate 2022-05-31 10:49:37
*/
@Service
public class BillGoodServiceImpl extends ServiceImpl<BillGoodMapper, BillGood>
    implements BillGoodService{
  
  @Override
  public List<BillGoodVO> queryListByBillId( Long id ) {
    return baseMapper.queryListByBillId( id );
  }
}




