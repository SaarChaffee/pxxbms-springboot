package com.chaffee.entity.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName user_role
 */
@TableName( value = "user_role" )
@Data
public class UserRole implements Serializable {
  /**
   * 主键ID
   */
  @TableId( value = "id", type = IdType.AUTO )
  private Long id;
  
  /**
   * 角色编码
   */
  @TableField( value = "roleCode" )
  private Long roleCode;
  
  /**
   * 角色名称
   */
  @TableField( value = "roleName" )
  private String roleName;
  
  /**
   * 创建者
   */
  @TableField( value = "createdBy" )
  private Long createdBy;
  
  /**
   * 创建时间
   */
  @TableField( value = "creationDate", fill = FieldFill.INSERT )
  private LocalDateTime creationDate;
  
  /**
   * 修改者
   */
  @TableField( value = "modifyBy" )
  private Long modifyBy;
  
  /**
   * 修改时间
   */
  @TableField( value = "modifyDate", fill = FieldFill.INSERT_UPDATE )
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
    UserRole other = ( UserRole ) that;
    return ( this.getId() == null ? other.getId() == null : this.getId().equals( other.getId() ) )
        && ( this.getRoleCode() == null ? other.getRoleCode() == null :
        this.getRoleCode().equals( other.getRoleCode() ) )
        && ( this.getRoleName() == null ? other.getRoleName() == null :
        this.getRoleName().equals( other.getRoleName() ) )
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
    result = prime * result + ( ( getRoleCode() == null ) ? 0 : getRoleCode().hashCode() );
    result = prime * result + ( ( getRoleName() == null ) ? 0 : getRoleName().hashCode() );
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
    sb.append( ", roleCode=" ).append( roleCode );
    sb.append( ", roleName=" ).append( roleName );
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
