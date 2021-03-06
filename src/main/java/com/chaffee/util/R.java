package com.chaffee.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@ApiModel( value = "全局统一返回结果" )
public class R {
  
  @ApiModelProperty( value = "是否成功" )
  private Boolean success;
  
  @ApiModelProperty( value = "返回码" )
  private Integer code;
  
  @ApiModelProperty( value = "返回消息" )
  private String message;
  
  @ApiModelProperty( value = "返回数据" )
  private Map<Object, Object> datas;
  
  @ApiModelProperty( value = "返回DTO" )
  private Object data;
  
  private R() {
  }
  
  public static R ok() {
    R r = new R();
    r.setSuccess( ResultCodeEnum.SUCCESS.getSuccess() );
    r.setCode( ResultCodeEnum.SUCCESS.getCode() );
    r.setMessage( ResultCodeEnum.SUCCESS.getMessage() );
    return r;
  }
  
  public static R error() {
    R r = new R();
    r.setSuccess( ResultCodeEnum.UNKNOWN_REASON.getSuccess() );
    r.setCode( ResultCodeEnum.UNKNOWN_REASON.getCode() );
    r.setMessage( ResultCodeEnum.UNKNOWN_REASON.getMessage() );
    return r;
  }
  
  public static R unauth() {
    R r = new R();
    r.setSuccess( ResultCodeEnum.UNAUTHORIZED.getSuccess() );
    r.setCode( ResultCodeEnum.UNAUTHORIZED.getCode() );
    r.setMessage( ResultCodeEnum.UNAUTHORIZED.getMessage() );
    return r;
  }
  
  public static R setResult( ResultCodeEnum resultCodeEnum ) {
    R r = new R();
    r.setSuccess( resultCodeEnum.getSuccess() );
    r.setCode( resultCodeEnum.getCode() );
    r.setMessage( resultCodeEnum.getMessage() );
    return r;
  }
  
  public R success( Boolean success ) {
    this.setSuccess( success );
    return this;
  }
  
  public R message( String message ) {
    this.setMessage( message );
    return this;
  }
  
  public R code( Integer code ) {
    this.setCode( code );
    return this;
  }
  
  public R datas( String key, Object value ) {
    if( this.datas == null ){
      this.datas = new HashMap<Object, Object>();
    }
    this.datas.put( key, value );
    return this;
  }
  
  public R datas( Map<Object, Object> map ) {
    this.setDatas( map );
    return this;
  }
  
  public R data( Object data ) {
    this.setData( data );
    return this;
  }
}
