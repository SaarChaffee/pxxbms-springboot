package com.chaffee.entity.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName good
 */
@TableName( value = "good" )
@Data
public class Good implements Serializable {
  /**
   * 主键ID
   */
  @TableId( value = "id", type = IdType.ASSIGN_ID )
  private Long id;
  
  /**
   * 商品名
   */
  @TableField( value = "goodName" )
  private String goodName;
  
  /**
   * 商品编号
   */
  @TableField( value = "goodCode" )
  private String goodCode;
  
  /**
   * 商品类别
   */
  @TableField( value = "goodType" )
  private Long goodType;
  
  /**
   * 商品库存
   */
  @TableField( value = "inventory" )
  private Long inventory;
  
  /**
   * 商品拥有者(取自用户表)
   */
  @TableField( value = "owner" )
  private Long owner;
  
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
  
  @TableField( value = "details" )
  private Long details;
  
  @TableField(value = "description")
  private Long description;
  
  
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
    Good other = ( Good ) that;
    return ( this.getId() == null ? other.getId() == null : this.getId().equals( other.getId() ) )
        && ( this.getGoodName() == null ? other.getGoodName() == null :
        this.getGoodName().equals( other.getGoodName() ) )
        && ( this.getGoodCode() == null ? other.getGoodCode() == null :
        this.getGoodCode().equals( other.getGoodCode() ) )
        && ( this.getGoodType() == null ? other.getGoodType() == null :
        this.getGoodType().equals( other.getGoodType() ) )
        && ( this.getInventory() == null ? other.getInventory() == null :
        this.getInventory().equals( other.getInventory() ) )
        && ( this.getOwner() == null ? other.getOwner() == null : this.getOwner().equals( other.getOwner() ) )
        && ( this.getCreatedBy() == null ? other.getCreatedBy() == null :
        this.getCreatedBy().equals( other.getCreatedBy() ) )
        && ( this.getCreationDate() == null ? other.getCreationDate() == null :
        this.getCreationDate().equals( other.getCreationDate() ) )
        && ( this.getModifyBy() == null ? other.getModifyBy() == null :
        this.getModifyBy().equals( other.getModifyBy() ) )
        && ( this.getModifyDate() == null ? other.getModifyDate() == null :
        this.getModifyDate().equals( other.getModifyDate() ) )
        && ( this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals( other.getVersion() ) )
        && ( this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals( other.getDeleted() ) )
        && ( this.getDetails() == null ? other.getDetails() == null : this.getDetails().equals( other.getDetails() ) )
        && ( this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals( other.getDescription() ));
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ( ( getId() == null ) ? 0 : getId().hashCode() );
    result = prime * result + ( ( getGoodName() == null ) ? 0 : getGoodName().hashCode() );
    result = prime * result + ( ( getGoodCode() == null ) ? 0 : getGoodCode().hashCode() );
    result = prime * result + ( ( getGoodType() == null ) ? 0 : getGoodType().hashCode() );
    result = prime * result + ( ( getInventory() == null ) ? 0 : getInventory().hashCode() );
    result = prime * result + ( ( getOwner() == null ) ? 0 : getOwner().hashCode() );
    result = prime * result + ( ( getCreatedBy() == null ) ? 0 : getCreatedBy().hashCode() );
    result = prime * result + ( ( getCreationDate() == null ) ? 0 : getCreationDate().hashCode() );
    result = prime * result + ( ( getModifyBy() == null ) ? 0 : getModifyBy().hashCode() );
    result = prime * result + ( ( getModifyDate() == null ) ? 0 : getModifyDate().hashCode() );
    result = prime * result + ( ( getVersion() == null ) ? 0 : getVersion().hashCode() );
    result = prime * result + ( ( getDeleted() == null ) ? 0 : getDeleted().hashCode() );
    result = prime * result + ( ( getDetails() == null ? 0 : getDetails().hashCode() ) );
    result = prime * result + ( (getDescription() == null ? 0 : getDescription().hashCode()));
    return result;
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append( getClass().getSimpleName() );
    sb.append( " [" );
    sb.append( "Hash = " ).append( hashCode() );
    sb.append( ", id=" ).append( id );
    sb.append( ", goodName=" ).append( goodName );
    sb.append( ", goodCode=" ).append( goodCode );
    sb.append( ", goodType=" ).append( goodType );
    sb.append( ", inventory=" ).append( inventory );
    sb.append( ", owner=" ).append( owner );
    sb.append( ", createdBy=" ).append( createdBy );
    sb.append( ", creationDate=" ).append( creationDate );
    sb.append( ", modifyBy=" ).append( modifyBy );
    sb.append( ", modifyDate=" ).append( modifyDate );
    sb.append( ", version=" ).append( version );
    sb.append( ", deleted=" ).append( deleted );
    sb.append( ", serialVersionUID=" ).append( serialVersionUID );
    sb.append( ", details=" ).append( details );
    sb.append( ", description=" ).append( description );
    sb.append( "]" );
    return sb.toString();
  }
}
