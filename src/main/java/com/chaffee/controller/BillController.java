/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/4
 */
package com.chaffee.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaffee.entity.dto.BillCodeDTO;
import com.chaffee.entity.dto.LoginDTO;
import com.chaffee.entity.pojo.Bill;
import com.chaffee.entity.pojo.PaymentMethod;
import com.chaffee.entity.vo.BillVO;
import com.chaffee.service.BillService;
import com.chaffee.service.PaymentMethodService;
import com.chaffee.util.Constants;
import com.chaffee.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping( "/bill" )
public class BillController {
  @Autowired
  BillService billService;
  @Autowired
  PaymentMethodService paymentMethodService;
  
  @GetMapping( "/list" )
  public String list( @RequestParam( value = "queryGoodName", required = false ) String queryGoodName,
                      @RequestParam( value = "queryCustomerName", required = false ) String queryCustomerName,
                      @RequestParam( value = "queryPaymentMethod", required = false ) String queruPaymentMethod,
                      @RequestParam( value = "pageIndex", required = false ) String pageIndex,
                      Model model ) {
    queryGoodName = !StringUtils.isEmpty( queryGoodName ) ? queryGoodName : "";
    queryCustomerName = !StringUtils.isEmpty( queryCustomerName ) ? queryCustomerName : "";
    int method = StringUtils.isNumber( queruPaymentMethod ) ? Integer.parseInt( queruPaymentMethod ) : 0;
    int index = StringUtils.isNumber( pageIndex ) ? Integer.parseInt( pageIndex ) : 1;
    
    Page<BillVO> page = new Page<BillVO>( index, 15 );
    List<BillVO> billList = billService.queryBillList( page, queryGoodName, queryCustomerName, method );
    List<PaymentMethod> methodList = paymentMethodService.list();
    model.addAttribute( "billList", billList );
    model.addAttribute( "methodList", methodList );
    model.addAttribute( "queryGoodName", queruPaymentMethod );
    model.addAttribute( "queryCustomerName", queryCustomerName );
    model.addAttribute( "queryPaymentMethod", method );
    model.addAttribute( "pageParam", page );
    return "bill/list";
  }
  
  @GetMapping("/list/{id}")
  public String list(@PathVariable("id")String billId,Model model){
    long id = StringUtils.isNumber( billId )? Long.parseLong(billId):0L;
    BillVO billVO = billService.queryBill( id );
    model.addAttribute( "bill",billVO );
    return "bill/view";
  }
  
  @GetMapping( "/toAdd" )
  public String toAdd( Model model ) {
    model.addAttribute( "methodList", paymentMethodService.list() );
    return "bill/add";
  }
  
  @PostMapping( "/add" )
  public String add( Bill bill, HttpSession session ) {
    LoginDTO login = ( LoginDTO ) session.getAttribute( Constants.USER_SESSION );
    bill.setCreatedBy( login.getId() );
    bill.setBillTime( LocalDateTime.now() );
    billService.save( bill );
    return "redirect:/bill/list";
  }
  
  @GetMapping( "/exist" )
  @ResponseBody
  public R exist( @RequestParam( "billCode" ) String billCode ) {
    BillCodeDTO bill = billService.queryGoodByCode( billCode );
    if( bill != null ){
      return R.ok().data( bill );
    }
    else return R.error();
  }
  
  @GetMapping( "/toUpd/{id}" )
  public String toUpd( @PathVariable( "id" ) String billId, Model model ) {
    long id = StringUtils.isNumber( billId ) ? Long.parseLong( billId ) : 0L;
    Bill bill = billService.getById( id );
    List<PaymentMethod> methodList = paymentMethodService.list();
    model.addAttribute( "bill", bill );
    model.addAttribute( "methodList", methodList );
    return "bill/update";
  }
  
  @PostMapping("/upd")
  public String upd(Bill bill,HttpSession session){
    LoginDTO login = ( LoginDTO ) session.getAttribute( Constants.USER_SESSION );
    bill.setModifyBy( login.getId() );
    boolean b = billService.updateById( bill );
    return "redirect:/bill/list";
  }
  
  @GetMapping("/del/{id}")
  public String del(@PathVariable("id")String billId){
    long id = StringUtils.isNumber( billId )? Long.parseLong(billId):0L;
    boolean b = billService.removeById( id );
    return "redirect:/bill/list";
  }
}
