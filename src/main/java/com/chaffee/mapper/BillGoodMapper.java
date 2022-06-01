package com.chaffee.mapper;

import com.chaffee.entity.pojo.BillGood;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaffee.entity.vo.BillGoodVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author RGB
* @description 针对表【bill_good】的数据库操作Mapper
* @createDate 2022-05-31 10:49:36
* @Entity com.chaffee.entity.pojo.BillGood
*/
@Mapper
public interface BillGoodMapper extends BaseMapper<BillGood> {
  List<BillGoodVO> queryListByBillId( @Param( "id" ) Long id );
}




