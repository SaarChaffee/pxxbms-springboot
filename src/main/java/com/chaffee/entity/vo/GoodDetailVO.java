/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/6/2
 */
package com.chaffee.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodDetailVO implements Serializable {
  private Long id;
  private String cover;
  private String title;
  private Long version;
}
