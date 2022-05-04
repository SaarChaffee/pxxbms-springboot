/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/4
 */
package com.chaffee.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaffee.entity.pojo.GoodType;
import com.chaffee.entity.vo.GoodVO;
import com.chaffee.service.GoodService;
import com.chaffee.service.GoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
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
}
