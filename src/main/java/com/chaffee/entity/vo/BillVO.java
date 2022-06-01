/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/4/30
 */
package com.chaffee.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class BillVO implements Serializable {
  
  /**
   * 主键ID
   */
  private Long id;
  /**
   * 订单号
   */
  private String billCode;
  /**
   * 商品数量
   */
  private Long goodCount;
  /**
   * 总价
   */
  private Double totalPrice;
  /**
   * 顾客编号
   */
  private Long customerCode;
  /**
   * 配送地址
   */
  private String address;
  /**
   * 下单时间
   */
  private Date billTime;
  /**
   * 支付方式
   */
  private Long paymentMethod;
  /**
   * 配送时间
   */
  private Date deliveryTime;

  /**
   * 顾客姓名
   */
  private String customerName;
  /**
   * 支付方式
   */
  private String paymentMethodName;
  /**
   * 订单内的商品列表
   */
  private List<BillGoodVO> goods;
  
}
