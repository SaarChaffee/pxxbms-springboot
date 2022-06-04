/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/4/30
 */
package com.chaffee.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodVO implements Serializable {
  /**
   * 主键ID
   */
  private Long id;
  /**
   * 商品名
   */
  private String goodName;
  /**
   * 商品编号
   */
  private String goodCode;
  /**
   * 父类型
   */
  private Long goodType;
  /**
   * 商品库存
   */
  private Long inventory;
  /**
   * 商品拥有者(取自用户表)
   */
  private Long owner;
  /**
   * 商品类型
   */
  private String goodTypeName;
  /**
   * 商家名
   */
  private String ownerName;
  /**
   *  乐观锁
   */
  private Long version;
  /**
   * 商品详情
   */
  private GoodDetailVO detail;
  /**
   *  描述
   */
  private GoodDescriptionVO description;
}
