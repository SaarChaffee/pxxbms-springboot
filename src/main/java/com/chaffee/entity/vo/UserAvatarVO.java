/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/6/7
 */
package com.chaffee.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserAvatarVO implements Serializable {
  private Long id;
  private String avatar;
  private Long version;
}
