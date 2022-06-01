/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/4
 */
package com.chaffee.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaffee.entity.dto.GoodCodeDTO;
import com.chaffee.entity.dto.LoginDTO;
import com.chaffee.entity.pojo.Good;
import com.chaffee.entity.pojo.GoodType;
import com.chaffee.entity.vo.GoodVO;
import com.chaffee.service.GoodService;
import com.chaffee.service.GoodTypeService;
import com.chaffee.util.Constants;
import com.chaffee.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping( "/good" )
public class GoodController {
  @Autowired
  GoodService goodService;
  @Autowired
  GoodTypeService goodTypeService;
  
  @GetMapping( "/list" )
  public String list( @RequestParam( value = "queryGoodName", required = false ) String queryGoodName,
                      @RequestParam( value = "queryOwnerName", required = false ) String queryOwnerName,
                      @RequestParam( value = "queryGoodType", required = false ) String queryGoodType,
                      @RequestParam( value = "pageIndex", required = false ) String pageIndex,
                      Model model ) {
    queryGoodName = StringUtils.isEmpty( queryGoodName ) ? "" : queryGoodName;
    queryOwnerName = StringUtils.isEmpty( queryOwnerName ) ? "" : queryOwnerName;
    int goodType = StringUtils.isNumber( queryGoodType ) && !queryGoodType.contains( "-" ) ?
        Integer.parseInt( queryGoodType ) : 0;
    int index = StringUtils.isNumber( pageIndex ) && !pageIndex.contains( "-" ) ? Integer.parseInt( pageIndex ) : 1;
    
    Page<GoodVO> page = new Page<>( index, 15 );
    List<GoodVO> goodList = goodService.queryGoodList( page, queryGoodName, queryOwnerName, goodType );
    List<GoodType> typeList = goodTypeService.list();
    model.addAttribute( "queryGoodName", queryGoodName );
    model.addAttribute( "queryOwnerName", queryOwnerName );
    model.addAttribute( "queryGoodType", goodType );
    model.addAttribute( "typeList", typeList );
    model.addAttribute( "pageParam", page );
    model.addAttribute( "goods", goodList );
    return "good/list";
  }
  
  @GetMapping( "/list/{id}" )
  public String list( @PathVariable( "id" ) String goodId, Model model ) {
    long id = StringUtils.isNumber( goodId ) ? Long.parseLong( goodId ) : 0L;
    GoodVO goodVO = goodService.queryGood( id );
    model.addAttribute( "good", goodVO );
    return "good/view";
  }
  
  @GetMapping( "/toAdd" )
  public String toAdd( Model model ) {
    model.addAttribute( "typeList", goodTypeService.list() );
    return "good/add";
  }
  
  @PostMapping( "/add" )
  public String add( Good good, HttpSession session ) {
    LoginDTO login = ( LoginDTO ) session.getAttribute( Constants.USER_SESSION );
    good.setCreatedBy( login.getId() );
    good.setModifyBy( login.getId() );
    try{
      goodService.save( good );
    }catch( Exception e ){
      e.printStackTrace();
    }
    return "redirect:/user/lsit";
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
  public String toUpd( @PathVariable( "id" ) String goodId, Model model ) {
    long id = StringUtils.isNumber( goodId ) ? Long.parseLong( goodId ) : 0L;
    Good good = goodService.getById( id );
    List<GoodType> typeList = goodTypeService.list();
    model.addAttribute( "good", good );
    model.addAttribute( "typeList", typeList );
    return "good/update";
  }
  
  @PostMapping( "/upd" )
  public String upd( Good good, HttpSession session ) {
    LoginDTO login = ( LoginDTO ) session.getAttribute( Constants.USER_SESSION );
    good.setModifyBy( login.getId() );
    try{
      goodService.updateById( good );
    }catch( Exception e ){
      e.printStackTrace();
    }
    return "redirect:/good/list";
  }
  
  @GetMapping( "/delGood/{id}" )
  public String del( @PathVariable( "id" ) String goodId ) {
    long id = StringUtils.isNumber( goodId ) ? Long.parseLong( goodId ) : 0L;
    boolean b = goodService.removeById( id );
    return "redirect:/good/list";
  }
  
  @GetMapping( "/get/{id}" )
  @ResponseBody
  public R getGoodById( @PathVariable( "id" ) String goodId ) {
    long id = StringUtils.isNumber( goodId ) ? Long.parseLong( goodId ) : 0L;
    Good good = goodService.getById( id );
    if( good != null ){
      return R.ok().data( good );
    }
    else return R.error();
  }
}
