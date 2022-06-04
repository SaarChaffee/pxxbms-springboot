/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/6/2
 */
package com.chaffee.controller;

import com.chaffee.service.UploadService;
import com.chaffee.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
public class UploadController {
  
  @Autowired
  UploadService uploadService;
  
  @ResponseBody
  @PostMapping( "/upload/{dir}" )
  public R upload( @RequestParam( "file" ) MultipartFile multipartFile,
                   @PathVariable("dir")String dir ) {
    
    if( multipartFile.isEmpty() ){
      return R.error().message( "不能上传空文件" );
    }
    Map<Object, Object> map = uploadService.upload( multipartFile, dir );
    if( map != null ){
      return R.ok().datas( map );
    }
    else{
      return R.error().message( "上传失败" );
    }
  }
}
