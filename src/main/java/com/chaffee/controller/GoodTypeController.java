/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/6/5
 */
package com.chaffee.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chaffee.entity.pojo.GoodType;
import com.chaffee.service.GoodTypeService;
import com.chaffee.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/goodtype" )
public class GoodTypeController {
  @Autowired
  GoodTypeService goodTypeService;
  
  @GetMapping( "/list" )
  public R list() {
    List<GoodType> list = goodTypeService.list();
    return R.ok()
        .datas( "typeList", list );
  }
  
  @GetMapping( "/list/{id}" )
  public R list( @PathVariable( "id" ) String typeId ) {
    long id = StringUtils.isNumber( typeId ) ? Long.parseLong( typeId ) : 0L;
    GoodType type = goodTypeService.getById( id );
    return R.ok()
        .datas( "goodType", type );
  }
  
  @PostMapping( "/add" )
  public R add( GoodType goodType, String currentId ) {
    Long curId = StringUtils.isNumber( currentId ) ? Long.parseLong( currentId ) : 0L;
    boolean result = false;
    goodType.setCreatedBy( curId );
    System.out.println(goodType);
    try{
      result = goodTypeService.save( goodType );
    }catch( Exception e ){
      e.printStackTrace();
    }
    return result ? R.ok().message( "添加成功" ) : R.error().message( "添加失败" );
  }
  
  @GetMapping( "/exist" )
  @ResponseBody
  public R exist( @RequestParam String typeCode ) {
    QueryWrapper<GoodType> wrapper = new QueryWrapper<>();
    wrapper.eq( "typeCode", typeCode );
    GoodType type = goodTypeService.getOne( wrapper );
    if( type != null ){
      return R.ok().data( type );
    }
    return R.ok();
  }
  
  @GetMapping( "/toUpd/{id}" )
  public R toUpd( @PathVariable( "id" ) String goodId ) {
    long id = StringUtils.isNumber( goodId ) ? Long.parseLong( goodId ) : 0L;
    GoodType type = goodTypeService.getById( id );
    return R.ok()
        .datas( "goodType", type );
  }
  
  @PostMapping( "/upd" )
  public R upd( GoodType goodType, String currentId ) {
    Long curId = StringUtils.isNumber( currentId ) ? Long.parseLong( currentId ) : 0L;
    goodType.setModifyBy( curId );
    boolean result = false;
    try{
      result = goodTypeService.saveOrUpdate( goodType );
    }catch( Exception e ){
      e.printStackTrace();
    }
    return result ? R.ok().message( "修改成功" ) : R.error().message( "修改失败" );
  }
  
  @GetMapping("/del/{id}")
  public R del(@PathVariable("id")String typeId){
    long id = StringUtils.isNumber( typeId ) ? Long.parseLong( typeId ) : 0L;
    boolean result = goodTypeService.removeById( id );
    return result ? R.ok().message( "删除成功" ) : R.error().message( "删除失败" );
  }
  
}
