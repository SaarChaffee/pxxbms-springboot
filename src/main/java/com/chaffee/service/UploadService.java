/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/6/2
 */
package com.chaffee.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UploadService {
  
  Map<Object, Object> upload( MultipartFile multipartFile, String dir );
  
}
