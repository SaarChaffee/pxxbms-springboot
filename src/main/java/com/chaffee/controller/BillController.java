/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/4
 */
package com.chaffee.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaffee.entity.pojo.PaymentMethod;
import com.chaffee.entity.vo.BillVO;
import com.chaffee.service.BillService;
import com.chaffee.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
  
  @GetMapping( "/toAdd" )
  public String toAdd( Model model ) {
    model.addAttribute( "methodList", paymentMethodService.list() );
    return "bill/add";
  }
}
