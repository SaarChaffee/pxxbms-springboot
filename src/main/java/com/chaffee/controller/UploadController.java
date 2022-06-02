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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class UploadController {
  
  @Autowired
  UploadService uploadService;
  
  @ResponseBody
  @PostMapping( "/upload" )
  public R upload( @RequestParam( "file" ) MultipartFile multipartFile,
                    HttpServletRequest request ) {
    
    if( multipartFile.isEmpty() ){
      return R.error().message( "不能上传空文件" );
    }
    Map<Object, Object> map = uploadService.upload( multipartFile, request.getParameter( "dir" ) );
    if( map != null ){
      return R.ok().datas( map );
    }
    else{
      return R.error().message( "上传失败" );
    }
  }
}
