package com.chaffee.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaffee.entity.dto.BillCodeDTO;
import com.chaffee.entity.pojo.Bill;
import com.chaffee.entity.vo.BillVO;
import com.chaffee.service.BillService;
import com.chaffee.mapper.BillMapper;
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
  
  @Override
  public List<BillVO> queryBillList( IPage<BillVO> page, String goodName, String customerName, int paymentMethod ) {
    return baseMapper.queryBillList( page, goodName, customerName, paymentMethod );
  }
  
  @Override
  public BillVO queryBill( long id ) {
    return baseMapper.queryBill( id );
  }
  
  @Override
  public BillCodeDTO queryGoodByCode( String billCode ) {
    return baseMapper.queryGoodByCode( billCode );
  }
}




