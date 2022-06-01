package com.chaffee.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaffee.entity.dto.BillCodeDTO;
import com.chaffee.entity.pojo.Bill;
import com.chaffee.entity.vo.BillVO;
import com.chaffee.mapper.BillMapper;
import com.chaffee.service.BillGoodService;
import com.chaffee.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author RGB
 * @description 针对表【bill】的数据库操作Service实现
 * @createDate 2022-04-30 10:31:55
 */
@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill>
    implements BillService {
  
  @Autowired
  BillGoodService billGoodService;
  
  @Override
  public List<BillVO> queryBillList( IPage<BillVO> page, String customerName, long paymentMethod ) {
    List<BillVO> billVOS = baseMapper.queryBillList( page, customerName, paymentMethod );
    billVOS.forEach( b -> {
      b.setGoods( billGoodService.queryListByBillId( b.getId() ) );
    } );
    return billVOS;
  }
  
  @Override
  public BillVO queryBill( long id ) {
    BillVO billVO = baseMapper.queryBill( id );
    billVO.setGoods( billGoodService.queryListByBillId( billVO.getId() ) );
    return billVO;
  }
  
  @Override
  public BillCodeDTO queryGoodByCode( String billCode ) {
    return baseMapper.queryGoodByCode( billCode );
  }
}




