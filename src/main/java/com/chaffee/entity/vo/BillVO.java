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
   * 商品编号
   */
  private Integer goodCode;
  /**
   * 购买数量
   */
  private Integer quantity;
  /**
   * 商品单价
   */
  private Double goodPrice;
  /**
   * 总价
   */
  private Double totalPrice;
  /**
   * 顾客编号
   */
  private Integer customerCode;
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
  private Integer paymentMethod;
  /**
   * 配送时间
   */
  private Date deliveryTime;
  /**
   * 创建者
   */
  private Integer createdBy;
  /**
   * 创建时间
   */
  private Date creationDate;
  /**
   * 修改者
   */
  private Integer modifyBy;
  /**
   * 修改时间
   */
  private Date modifyDate;
  
  /**
   * 顾客姓名
   */
  private String customerName;
  /**
   * 商品名
   */
  private String goodName;
  /**
   * 支付方式
   */
  private String paymentMethodName;
  /**
   * 商品数量
   */
  private Long goodCount;
  
}
