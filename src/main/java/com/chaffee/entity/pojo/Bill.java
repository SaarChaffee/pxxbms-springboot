package com.chaffee.entity.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName bill
 */
@TableName( value = "bill" )
@Data
public class Bill implements Serializable {
  /**
   * 主键ID
   */
  @TableId( value = "id", type = IdType.ASSIGN_ID )
  private Long id;
  
  /**
   * 订单号
   */
  @TableField( value = "billCode" )
  private String billCode;
  
  /**
   * 商品编号
   */
  @TableField( value = "goodCode" )
  private Long goodCode;
  
  /**
   * 购买数量
   */
  @TableField( value = "quantity" )
  private Long quantity;
  
  /**
   * 商品单价
   */
  @TableField( value = "goodPrice" )
  private Double goodPrice;
  
  /**
   * 总价
   */
  @TableField( value = "totalPrice" )
  private Double totalPrice;
  
  /**
   * 顾客编号
   */
  @TableField( value = "customerCode" )
  private Long customerCode;
  
  /**
   * 配送地址
   */
  @TableField( value = "address" )
  private String address;
  
  /**
   * 下单时间
   */
  @TableField( value = "billTime" )
  private LocalDateTime billTime;
  
  /**
   * 支付方式
   */
  @TableField( value = "paymentMethod" )
  private Long paymentMethod;
  
  /**
   * 配送时间
   */
  @TableField( value = "deliveryTime" )
  private LocalDateTime deliveryTime;
  
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
    Bill other = ( Bill ) that;
    return ( this.getId() == null ? other.getId() == null : this.getId().equals( other.getId() ) )
        && ( this.getBillCode() == null ? other.getBillCode() == null :
        this.getBillCode().equals( other.getBillCode() ) )
        && ( this.getGoodCode() == null ? other.getGoodCode() == null :
        this.getGoodCode().equals( other.getGoodCode() ) )
        && ( this.getQuantity() == null ? other.getQuantity() == null :
        this.getQuantity().equals( other.getQuantity() ) )
        && ( this.getGoodPrice() == null ? other.getGoodPrice() == null :
        this.getGoodPrice().equals( other.getGoodPrice() ) )
        && ( this.getTotalPrice() == null ? other.getTotalPrice() == null :
        this.getTotalPrice().equals( other.getTotalPrice() ) )
        && ( this.getCustomerCode() == null ? other.getCustomerCode() == null :
        this.getCustomerCode().equals( other.getCustomerCode() ) )
        && ( this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals( other.getAddress() ) )
        && ( this.getBillTime() == null ? other.getBillTime() == null :
        this.getBillTime().equals( other.getBillTime() ) )
        && ( this.getPaymentMethod() == null ? other.getPaymentMethod() == null :
        this.getPaymentMethod().equals( other.getPaymentMethod() ) )
        && ( this.getDeliveryTime() == null ? other.getDeliveryTime() == null :
        this.getDeliveryTime().equals( other.getDeliveryTime() ) )
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
    result = prime * result + ( ( getBillCode() == null ) ? 0 : getBillCode().hashCode() );
    result = prime * result + ( ( getGoodCode() == null ) ? 0 : getGoodCode().hashCode() );
    result = prime * result + ( ( getQuantity() == null ) ? 0 : getQuantity().hashCode() );
    result = prime * result + ( ( getGoodPrice() == null ) ? 0 : getGoodPrice().hashCode() );
    result = prime * result + ( ( getTotalPrice() == null ) ? 0 : getTotalPrice().hashCode() );
    result = prime * result + ( ( getCustomerCode() == null ) ? 0 : getCustomerCode().hashCode() );
    result = prime * result + ( ( getAddress() == null ) ? 0 : getAddress().hashCode() );
    result = prime * result + ( ( getBillTime() == null ) ? 0 : getBillTime().hashCode() );
    result = prime * result + ( ( getPaymentMethod() == null ) ? 0 : getPaymentMethod().hashCode() );
    result = prime * result + ( ( getDeliveryTime() == null ) ? 0 : getDeliveryTime().hashCode() );
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
    sb.append( ", billCode=" ).append( billCode );
    sb.append( ", goodCode=" ).append( goodCode );
    sb.append( ", quantity=" ).append( quantity );
    sb.append( ", goodPrice=" ).append( goodPrice );
    sb.append( ", totalPrice=" ).append( totalPrice );
    sb.append( ", customerCode=" ).append( customerCode );
    sb.append( ", address=" ).append( address );
    sb.append( ", billTime=" ).append( billTime );
    sb.append( ", paymentMethod=" ).append( paymentMethod );
    sb.append( ", deliveryTime=" ).append( deliveryTime );
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
