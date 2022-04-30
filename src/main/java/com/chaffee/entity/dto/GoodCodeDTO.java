/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/4/30
 */
package com.chaffee.entity.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodCodeDTO implements Serializable {
  private Integer id;
  private String goodCode;
  private String goodName;
  private Integer inventory;
}
