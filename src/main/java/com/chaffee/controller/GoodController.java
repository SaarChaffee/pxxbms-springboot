/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/4
 */
package com.chaffee.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaffee.entity.dto.GoodCodeDTO;
import com.chaffee.entity.pojo.Good;
import com.chaffee.entity.pojo.GoodDescription;
import com.chaffee.entity.pojo.GoodDetails;
import com.chaffee.entity.pojo.GoodType;
import com.chaffee.entity.vo.GoodVO;
import com.chaffee.service.GoodDescriptionService;
import com.chaffee.service.GoodDetailsService;
import com.chaffee.service.GoodService;
import com.chaffee.service.GoodTypeService;
import com.chaffee.util.R;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/good" )
public class GoodController {
  @Autowired
  GoodService goodService;
  @Autowired
  GoodDetailsService goodDetailsService;
  @Autowired
  GoodDescriptionService goodDescriptionService;
  @Autowired
  GoodTypeService goodTypeService;
  
  @GetMapping( "/list" )
  public R list( @RequestParam( value = "queryGoodName", required = false ) String queryGoodName,
                 @RequestParam( value = "queryOwnerName", required = false ) String queryOwnerName,
                 @RequestParam( value = "queryGoodType", required = false ) String queryGoodType,
                 @RequestParam( value = "pageIndex", required = false ) String pageIndex ) {
    queryGoodName = StringUtils.isEmpty( queryGoodName ) ? "" : queryGoodName;
    queryOwnerName = StringUtils.isEmpty( queryOwnerName ) ? "" : queryOwnerName;
    long goodType = StringUtils.isNumber( queryGoodType ) && !queryGoodType.contains( "-" ) ?
        Long.parseLong( queryGoodType ) : 0;
    int index = StringUtils.isNumber( pageIndex ) && !pageIndex.contains( "-" ) ? Integer.parseInt( pageIndex ) : 1;
    
    Page<GoodVO> page = new Page<>( index, 15 );
    List<GoodVO> goodList = goodService.queryGoodList( page, queryGoodName, queryOwnerName, goodType );
    List<GoodType> typeList = goodTypeService.list();
    return R.ok()
        .datas( "queryGoodName", queryGoodName )
        .datas( "queryOwnerName", queryOwnerName )
        .datas( "queryGoodType", goodType )
        .datas( "typeList", typeList )
        .datas( "pageParam", page )
        .datas( "goods", goodList );
  }
  
  @GetMapping( "/list/{id}" )
  public R list( @PathVariable( "id" ) String goodId ) {
    long id = StringUtils.isNumber( goodId ) ? Long.parseLong( goodId ) : 0L;
    GoodVO goodVO = goodService.queryGood( id );
    return R.ok()
        .datas( "good", goodVO );
  }
  
  @GetMapping( "/toAdd" )
  public R toAdd() {
    return R.ok()
        .datas( "typeList", goodTypeService.list() );
  }
  
  @PostMapping( "/add/{id}" )
  public R add( @RequestBody GoodVO goodVO, @PathVariable( "id" ) String currentId ) {
    Long curId = StringUtils.isNumber( currentId ) ? Long.parseLong( currentId ) : 0L;
    Long id = IdWorker.getId( goodVO );
    Good good = new Good();
    GoodDetails details = new GoodDetails();
    GoodDescription description = new GoodDescription();
    boolean result = false;
    BeanUtils.copyProperties( goodVO, good );
    BeanUtils.copyProperties( goodVO.getDetail(), details );
    BeanUtils.copyProperties( goodVO.getDescription(), description );
    good.setId( id );
    good.setCreatedBy( curId );
    details.setId( id );
    details.setCreatedBy( curId );
    description.setId( id );
    description.setCreatedBy( curId );
    try{
      result =
          goodService.save( good ) && goodDetailsService.save( details ) && goodDescriptionService.save( description );
    }catch( Exception e ){
      e.printStackTrace();
    }
    return result ? R.ok().message( "添加成功" ) : R.error().message( "添加失败" );
  }
  
  @GetMapping( "/exist" )
  @ResponseBody
  public R exist( @RequestParam String goodCode ) {
    GoodCodeDTO good = goodService.queryGoodByCode( goodCode );
    if( good != null ){
      return R.ok().data( good );
    }
    return R.error();
  }
  
  @GetMapping( "/toUpd/{id}" )
  public R toUpd( @PathVariable( "id" ) String goodId ) {
    long id = StringUtils.isNumber( goodId ) ? Long.parseLong( goodId ) : 0L;
    GoodVO good = goodService.queryGood( id );
    List<GoodType> typeList = goodTypeService.list();
    return R.ok()
        .datas( "good", good )
        .datas( "typeList", typeList );
  }
  
  @PostMapping( "/upd/{id}" )
  public R upd( @RequestBody GoodVO goodVO, @PathVariable( "id" ) String currentId ) {
    long curId = StringUtils.isNumber( currentId ) ? Long.parseLong( currentId ) : 0L;
    Good good = new Good();
    GoodDetails details = new GoodDetails();
    GoodDescription description = new GoodDescription();
    boolean result = false;
    BeanUtils.copyProperties( goodVO, good );
    BeanUtils.copyProperties( goodVO.getDetail(), details );
    BeanUtils.copyProperties( goodVO.getDescription(), description );
    good.setModifyBy( curId );
    details.setModifyBy( curId );
    description.setModifyBy( curId );
    try{
      result = goodService.updateById( good ) &&
          goodDetailsService.updateById( details ) &&
          goodDescriptionService.updateById( description );
    }catch( Exception e ){
      e.printStackTrace();
    }
    return result ? R.ok().message( "修改成功" ) : R.error().message( "修改失败" );
  }
  
  @GetMapping( "/del/{id}" )
  public R del( @PathVariable( "id" ) String goodId ) {
    long id = StringUtils.isNumber( goodId ) ? Long.parseLong( goodId ) : 0L;
    boolean result = goodService.removeById( id ) &&
        goodDetailsService.removeById( id ) &&
        goodDescriptionService.removeById( id );
    return result ? R.ok().message( "删除成功" ) : R.error().message( "删除失败" );
  }
}
