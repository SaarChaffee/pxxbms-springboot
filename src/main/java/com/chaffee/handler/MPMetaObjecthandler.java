/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/4/30
 */
package com.chaffee.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

public class MPMetaObjecthandler implements MetaObjectHandler {
  @Override
  public void insertFill( MetaObject metaObject ) {
    this.strictInsertFill( metaObject, "createTime", LocalDateTime::now, LocalDateTime.class );
    this.strictInsertFill( metaObject, "modifyTime", LocalDateTime::now, LocalDateTime.class );
  }
  
  @Override
  public void updateFill( MetaObject metaObject ) {
    this.strictUpdateFill( metaObject, "modifyTime", LocalDateTime::now, LocalDateTime.class );
  }
}
