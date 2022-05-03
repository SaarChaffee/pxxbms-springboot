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
   * 商品类别
   */
  private Integer goodType;
  /**
   * 商品库存
   */
  private Integer inventory;
  /**
   * 商品拥有者(取自用户表)
   */
  private Integer owner;
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
   * 商品类型
   */
  private String goodTypeName;
  /**
   * 商家名
   */
  private String ownerName;
}
