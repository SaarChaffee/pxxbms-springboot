/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/4/30
 */
package com.chaffee.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MPMetaObjecthandler implements MetaObjectHandler {
  @Override
  public void insertFill( MetaObject metaObject ) {
    this.strictInsertFill( metaObject, "creationDate", LocalDateTime::now, LocalDateTime.class );
    this.strictInsertFill( metaObject, "modifyDate", LocalDateTime::now, LocalDateTime.class );
  }
  
  @Override
  public void updateFill( MetaObject metaObject ) {
    this.strictUpdateFill( metaObject, "modifyDate", LocalDateTime::now, LocalDateTime.class );
  }
}
