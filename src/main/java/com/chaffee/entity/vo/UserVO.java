/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/4/30
 */
package com.chaffee.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Data
public class UserVO implements Serializable {
  /**
   * 主键ID
   */
  private Integer id;
  /**
   * 用户编码
   */
  private String userCode;
  /**
   * 用户名称
   */
  private String userName;
  /**
   * 用户密码
   */
  private String userPassword;
  /**
   * 性别（1:女、 2:男）
   */
  private Integer gender;
  /**
   * 出生日期
   */
  private Date birthday;
  /**
   * 手机
   */
  private String phone;
  /**
   * 地址
   */
  private String address;
  /**
   * 用户角色（取自角色表-角色id）
   */
  private Integer userRole;
  /**
   * 创建者（userId）
   */
  private Integer createdBy;
  /**
   * 创建时间
   */
  private Date creationDate;
  /**
   * 更新者（userId）
   */
  private Integer modifyBy;
  /**
   * 更新时间
   */
  private Date modifyDate;
  /**
   * 角色名
   */
  private String userRoleName;
  /**
   * 年龄
   */
  private int age;
  
  public void setBirthday( Date birthday ) {
    this.birthday = birthday;
    setAge();
  }
  
  public void setAge() {
    Calendar now = Calendar.getInstance();
    Calendar bir = Calendar.getInstance();
    now.setTime( new Date( System.currentTimeMillis() ) );
    bir.setTime( birthday );
//    System.out.println( now.getTime() );
//    System.out.println( bir.getTime() );
//    System.out.println( now.get( Calendar.YEAR ) - bir.get( Calendar.YEAR ) );
    this.age = now.get( Calendar.YEAR ) - bir.get( Calendar.YEAR );
  }
}
