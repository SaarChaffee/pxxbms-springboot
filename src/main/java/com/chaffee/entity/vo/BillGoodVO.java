/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/31
 */
package com.chaffee.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BillGoodVO implements Serializable {
  
  private Long billCode;
  
  private Long goodCode;
  
  private String goodName;
  
  private Long quantity;
  
  private Double price;

}
