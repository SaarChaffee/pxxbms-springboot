package com.chaffee.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chaffee.entity.dto.GoodCodeDTO;
import com.chaffee.entity.pojo.Good;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaffee.entity.vo.GoodVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author RGB
 * @description 针对表【good】的数据库操作Mapper
 * @createDate 2022-04-30 10:31:55
 * @Entity Good
 */
@Mapper
public interface GoodMapper extends BaseMapper<Good> {
  List<GoodVO> queryGoodList( @Param ( "page" )IPage<GoodVO> page,@Param( "goodName" )String goodName,@Param( "ownerName" )String ownerName,@Param( "goodType" )int goodType );
  
  GoodVO queryGood(@Param( "id" )long id);
  
  GoodCodeDTO queryGoodByCode(@Param( "goodCode" )String goodCode);
}




