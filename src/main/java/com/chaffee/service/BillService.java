package com.chaffee.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chaffee.entity.dto.BillCodeDTO;
import com.chaffee.entity.pojo.Bill;
import com.chaffee.entity.vo.BillVO;

import java.util.List;

/**
 * @author RGB
 * @description 针对表【bill】的数据库操作Service
 * @createDate 2022-04-30 10:31:55
 */
public interface BillService extends IService<Bill> {
  List<BillVO> queryBillList( IPage<BillVO> page,
                              String customerName,
                              long paymentMethod );
  
  BillVO queryBill( long id );
  
  BillCodeDTO queryGoodByCode( String billCode );
}
