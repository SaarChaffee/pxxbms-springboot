package com.chaffee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chaffee.entity.dto.BillCodeDTO;
import com.chaffee.entity.pojo.Bill;
import com.chaffee.entity.vo.BillVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author RGB
* @description 针对表【bill】的数据库操作Mapper
* @createDate 2022-04-30 10:31:55
* @Entity Bill
*/
@Mapper
public interface BillMapper extends BaseMapper<Bill> {
  List<BillVO> queryBillList( @Param("page")IPage<BillVO> page,
                              @Param( "customerName" )String customerName,
                              @Param( "paymentMethod" )long paymentMethod);
  
  BillVO queryBill(@Param( "id" )long id);
  
  BillCodeDTO queryGoodByCode(@Param( "billCode" )String billCode);
}




