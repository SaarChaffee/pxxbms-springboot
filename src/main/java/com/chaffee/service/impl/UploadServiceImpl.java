/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/6/2
 */
package com.chaffee.service.impl;

import com.chaffee.service.UploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {
  @Value( "${file.httpRootPath}" )
  private String httpRootPath;
  
  @Value( "${file.resourcePath}" )
  private String resourcePath;
  
  @Value( "${file.uploadPath}" )
  private String resourceFolder;
  
  @Override
  public Map<Object, Object> upload( MultipartFile multipartFile, String dir ) {
    try{
      String fileType =
          multipartFile.getOriginalFilename().substring( multipartFile.getOriginalFilename().lastIndexOf( "." ) );
      String fileName = UUID.randomUUID().toString().replace( "-", "" ) + fileType;
    
      String dataPath = new SimpleDateFormat( "yyyy/MM/dd" ).format( System.currentTimeMillis() );
    
      File basePath = new File( resourceFolder , dir );
      File targetPath = new File( basePath, dataPath );
      if( !targetPath.exists() ){
        targetPath.mkdirs();
      }
      File targetFileName = new File( targetPath, fileName );
      multipartFile.transferTo( targetFileName );
      String path = "/" + dir + "/" + dataPath + "/" + fileName;
      Map<Object, Object> map = new HashMap<>();
      map.put( "url", httpRootPath + resourcePath + path );
      map.put( "size", multipartFile.getSize() );
      map.put( "type", fileType.replace( ".","" ) );
      map.put( "fileName", fileName );
      map.put( "rPath", resourcePath + path );
      return map;
    }catch( IOException e ){
      e.printStackTrace();
      return null;
    }
  }
}
