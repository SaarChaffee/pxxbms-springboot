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
public class BillCodeDTO implements Serializable {
  private Long id;
  private String billCode;
}
