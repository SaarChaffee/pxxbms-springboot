/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/4
 */
package com.chaffee.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaffee.entity.dto.BillCodeDTO;
import com.chaffee.entity.pojo.Bill;
import com.chaffee.entity.pojo.BillGood;
import com.chaffee.entity.pojo.PaymentMethod;
import com.chaffee.entity.vo.BillGoodVO;
import com.chaffee.entity.vo.BillVO;
import com.chaffee.service.BillGoodService;
import com.chaffee.service.BillService;
import com.chaffee.service.PaymentMethodService;
import com.chaffee.util.R;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping( "/bill" )
public class BillController {
  @Autowired
  BillService billService;
  @Autowired
  BillGoodService billGoodService;
  @Autowired
  PaymentMethodService paymentMethodService;
  
  @GetMapping( "/list" )
  public R list( @RequestParam( value = "queryCustomerName", required = false ) String queryCustomerName,
                 @RequestParam( value = "queryPaymentMethod", required = false ) String queruPaymentMethod,
                 @RequestParam( value = "pageIndex", required = false ) String pageIndex,
                 @RequestParam( value = "pageSize", required = false ) String pageSize ) {
    queryCustomerName = !StringUtils.isEmpty( queryCustomerName ) ? queryCustomerName : "";
    long method = StringUtils.isNumber( queruPaymentMethod ) ? Long.parseLong( queruPaymentMethod ) : 0L;
    int index = StringUtils.isNumber( pageIndex ) ? Integer.parseInt( pageIndex ) : 1;
    int size = StringUtils.isNumber( pageSize ) && !pageIndex.contains( "-" ) ? Integer.parseInt( pageSize ) : 10;
    
    Page<BillVO> page = new Page<BillVO>( index, size );
    List<BillVO> billList = billService.queryBillList( page, queryCustomerName, method );
    List<PaymentMethod> methodList = paymentMethodService.list();
    return R.ok()
        .datas( "billList", billList )
        .datas( "methodList", methodList )
        .datas( "queryGoodName", queruPaymentMethod )
        .datas( "queryCustomerName", queryCustomerName )
        .datas( "queryPaymentMethod", method )
        .datas( "pageParam", page );
  }
  
  @GetMapping( "/list/{id}" )
  public R list( @PathVariable( "id" ) String billId ) {
    long id = StringUtils.isNumber( billId ) ? Long.parseLong( billId ) : 0L;
    BillVO billVO = billService.queryBill( id );
    return R.ok().datas( "bill", billVO );
  }
  
  @GetMapping( "/goods/{id}" )
  public R goods( @PathVariable( "id" ) String billId ) {
    long id = StringUtils.isNumber( billId ) ? Long.parseLong( billId ) : 0L;
    List<BillGoodVO> billGoodVOS = billGoodService.queryListByBillId( id );
    return R.ok()
        .datas( "goods", billGoodVOS );
  }
  
  @GetMapping( "/toAdd" )
  public R toAdd() {
    return R.ok().datas( "methodList", paymentMethodService.list() );
  }
  
  @PostMapping( "/add/{id}" )
  public R add( @RequestBody BillVO billVO, @PathVariable( "id" ) String currentId ) {
    Long curId = StringUtils.isNumber( currentId ) ? Long.parseLong( currentId ) : 0L;
    Long id = IdWorker.getId( billVO );
    billVO.setId( id );
    Bill bill = new Bill();
    BeanUtils.copyProperties( billVO, bill );
    bill.setCreatedBy( curId );
    bill.setBillTime( new Date( System.currentTimeMillis() ) );
    
    List<BillGoodVO> goods = billVO.getGoods();
    ArrayList<BillGood> billGoods = new ArrayList<>();
    goods.forEach( g -> {
      BillGood billGood = new BillGood();
      BeanUtils.copyProperties( g, billGood );
      billGood.setBillCode( id );
      billGood.setCreatedBy( curId );
      billGoods.add( billGood );
    } );
    
    boolean result = false;
    try{
      result = billService.save( bill ) && billGoodService.saveBatch( billGoods );
    }catch( Exception e ){
      e.printStackTrace();
    }
    return result ? R.ok().message( "添加成功" ) : R.error().message( "添加失败" );
  }
  
  @GetMapping( "/exist" )
  @ResponseBody
  public R exist( @RequestParam( "billCode" ) String billCode ) {
    BillCodeDTO bill = billService.queryGoodByCode( billCode );
    if( bill != null ){
      return R.ok().data( bill );
    }
    else return R.ok();
  }
  
  @GetMapping( "/toUpd/{id}" )
  public R toUpd( @PathVariable( "id" ) String billId ) {
    long id = StringUtils.isNumber( billId ) ? Long.parseLong( billId ) : 0L;
    BillVO bill = billService.queryBill( id );
    List<PaymentMethod> methodList = paymentMethodService.list();
    return R.ok()
        .datas( "billvo", bill )
        .datas( "methodList", methodList );
  }
  
  @PostMapping( "/upd/{id}" )
  public R upd( @RequestBody BillVO billVO, @PathVariable( "id" ) String currentId ) {
    Long curId = StringUtils.isNumber( currentId ) ? Long.parseLong( currentId ) : 0L;
    Bill bill = new Bill();
    BeanUtils.copyProperties( billVO, bill );
    bill.setModifyBy( curId );
    
    List<BillGoodVO> goods = billVO.getGoods();
    ArrayList<BillGood> billGoods = new ArrayList<>();
    goods.forEach( g -> {
      BillGood billGood = new BillGood();
      BeanUtils.copyProperties( g, billGood );
      billGood.setModifyBy( curId );
      billGood.setBillCode( bill.getId() );
      billGoods.add( billGood );
    } );
    billGoods.forEach( System.out::println );
    boolean result = false;
    try{
      result = billService.updateById( bill );
      billGoods.forEach( g -> {
        UpdateChainWrapper<BillGood> wrapper =
            new UpdateChainWrapper<>( billGoodService.getBaseMapper() );
        wrapper
            .eq( "billId", g.getBillCode() )
            .eq( "goodCode", g.getGoodCode() );
        billGoodService.saveOrUpdate( g, wrapper );
      } );
    }catch( Exception e ){
      e.printStackTrace();
    }
    return result ? R.ok().message( "修改成功" ) : R.error().message( "修改失败" );
  }
  
  @GetMapping( "/del/{id}" )
  public R del( @PathVariable( "id" ) String billId ) {
    long id = StringUtils.isNumber( billId ) ? Long.parseLong( billId ) : 0L;
    QueryWrapper<BillGood> wrapper = new QueryWrapper<>();
    wrapper.eq( "billCode", id );
    boolean result = billService.removeById( id ) && billGoodService.remove( wrapper );
    return result ? R.ok().message( "删除成功" ) : R.error().message( "删除失败" );
  }
  
  @GetMapping( "/delGoods" )
  public R delGoods( @RequestParam( "billCode" ) String billId,
                     @RequestParam( "goodCode" ) String goodId ) {
    long bId = StringUtils.isNumber( billId ) ? Long.parseLong( billId ) : 0L;
    long gId = StringUtils.isNumber( goodId ) ? Long.parseLong( goodId ) : 0L;
    QueryChainWrapper<BillGood> wrapper = new QueryChainWrapper<>( billGoodService.getBaseMapper() );
    wrapper
        .eq( "billCode", bId )
        .eq( "goodCode", gId );
    boolean result = billGoodService.remove( wrapper );
    return result ? R.ok().message( "删除成功" ) : R.error().message( "删除失败" );
  }
}
