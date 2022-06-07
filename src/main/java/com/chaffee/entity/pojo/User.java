package com.chaffee.entity.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @TableName user
 */
@TableName( value = "user" )
@Data
public class User implements Serializable {
  /**
   * 主键ID
   */
  @TableId( value = "id", type = IdType.ASSIGN_ID )
  private Long id;
  
  /**
   * 用户编码
   */
  @TableField( value = "userCode" )
  private String userCode;
  
  /**
   * 用户名称
   */
  @TableField( value = "userName" )
  private String userName;
  
  /**
   * 用户密码
   */
  @TableField( value = "userPassword" )
  private String userPassword;
  
  /**
   * 性别（1:女、 2:男）
   */
  @TableField( value = "gender" )
  private Integer gender;
  
  /**
   * 出生日期
   */
  @TableField( value = "birthday" )
  private Date birthday;
  
  /**
   * 手机
   */
  @TableField( value = "phone" )
  private String phone;
  
  /**
   * 地址
   */
  @TableField( value = "address" )
  private String address;
  
  /**
   * 用户角色（取自角色表-角色id）
   */
  @TableField( value = "userRole" )
  private Long userRole;
  
  /**
   * 创建者（userId）
   */
  @TableField( value = "createdBy" )
  private Long createdBy;
  
  /**
   * 创建时间
   */
  @TableField( value = "creationDate",fill = FieldFill.INSERT)
  private LocalDateTime creationDate;
  
  /**
   * 更新者（userId）
   */
  @TableField( value = "modifyBy" )
  private Long modifyBy;
  
  /**
   * 更新时间
   */
  @TableField( value = "modifyDate",fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime modifyDate;
  
  /**
   *
   */
  @Version
  @TableField( value = "version" )
  private Long version;
  
  /**
   *
   */
  @TableLogic
  @TableField( value = "deleted" )
  private Integer deleted;
  
  @TableField( exist = false )
  private static final long serialVersionUID = 1L;
  
  @Override
  public boolean equals( Object that ) {
    if( this == that ){
      return true;
    }
    if( that == null ){
      return false;
    }
    if( getClass() != that.getClass() ){
      return false;
    }
    User other = ( User ) that;
    return ( this.getId() == null ? other.getId() == null : this.getId().equals( other.getId() ) )
        && ( this.getUserCode() == null ? other.getUserCode() == null :
        this.getUserCode().equals( other.getUserCode() ) )
        && ( this.getUserName() == null ? other.getUserName() == null :
        this.getUserName().equals( other.getUserName() ) )
        && ( this.getUserPassword() == null ? other.getUserPassword() == null :
        this.getUserPassword().equals( other.getUserPassword() ) )
        && ( this.getGender() == null ? other.getGender() == null : this.getGender().equals( other.getGender() ) )
        && ( this.getBirthday() == null ? other.getBirthday() == null :
        this.getBirthday().equals( other.getBirthday() ) )
        && ( this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals( other.getPhone() ) )
        && ( this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals( other.getAddress() ) )
        && ( this.getUserRole() == null ? other.getUserRole() == null :
        this.getUserRole().equals( other.getUserRole() ) )
        && ( this.getCreatedBy() == null ? other.getCreatedBy() == null :
        this.getCreatedBy().equals( other.getCreatedBy() ) )
        && ( this.getCreationDate() == null ? other.getCreationDate() == null :
        this.getCreationDate().equals( other.getCreationDate() ) )
        && ( this.getModifyBy() == null ? other.getModifyBy() == null :
        this.getModifyBy().equals( other.getModifyBy() ) )
        && ( this.getModifyDate() == null ? other.getModifyDate() == null :
        this.getModifyDate().equals( other.getModifyDate() ) )
        && ( this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals( other.getVersion() ) )
        && ( this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals( other.getDeleted() ) );
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ( ( getId() == null ) ? 0 : getId().hashCode() );
    result = prime * result + ( ( getUserCode() == null ) ? 0 : getUserCode().hashCode() );
    result = prime * result + ( ( getUserName() == null ) ? 0 : getUserName().hashCode() );
    result = prime * result + ( ( getUserPassword() == null ) ? 0 : getUserPassword().hashCode() );
    result = prime * result + ( ( getGender() == null ) ? 0 : getGender().hashCode() );
    result = prime * result + ( ( getBirthday() == null ) ? 0 : getBirthday().hashCode() );
    result = prime * result + ( ( getPhone() == null ) ? 0 : getPhone().hashCode() );
    result = prime * result + ( ( getAddress() == null ) ? 0 : getAddress().hashCode() );
    result = prime * result + ( ( getUserRole() == null ) ? 0 : getUserRole().hashCode() );
    result = prime * result + ( ( getCreatedBy() == null ) ? 0 : getCreatedBy().hashCode() );
    result = prime * result + ( ( getCreationDate() == null ) ? 0 : getCreationDate().hashCode() );
    result = prime * result + ( ( getModifyBy() == null ) ? 0 : getModifyBy().hashCode() );
    result = prime * result + ( ( getModifyDate() == null ) ? 0 : getModifyDate().hashCode() );
    result = prime * result + ( ( getVersion() == null ) ? 0 : getVersion().hashCode() );
    result = prime * result + ( ( getDeleted() == null ) ? 0 : getDeleted().hashCode() );
    return result;
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append( getClass().getSimpleName() );
    sb.append( " [" );
    sb.append( "Hash = " ).append( hashCode() );
    sb.append( ", id=" ).append( id );
    sb.append( ", userCode=" ).append( userCode );
    sb.append( ", userName=" ).append( userName );
    sb.append( ", userPassword=" ).append( userPassword );
    sb.append( ", gender=" ).append( gender );
    sb.append( ", birthday=" ).append( birthday );
    sb.append( ", phone=" ).append( phone );
    sb.append( ", address=" ).append( address );
    sb.append( ", userRole=" ).append( userRole );
    sb.append( ", createdBy=" ).append( createdBy );
    sb.append( ", creationDate=" ).append( creationDate );
    sb.append( ", modifyBy=" ).append( modifyBy );
    sb.append( ", modifyDate=" ).append( modifyDate );
    sb.append( ", version=" ).append( version );
    sb.append( ", deleted=" ).append( deleted );
    sb.append( ", serialVersionUID=" ).append( serialVersionUID );
    sb.append( "]" );
    return sb.toString();
  }
}
