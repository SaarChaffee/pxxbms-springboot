/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/6/2
 */
package com.chaffee.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.chaffee.service.UploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {
  @Value("${aliyun.oss.file.endpoint}")
  public String END_POINT;
  
  @Value("${aliyun.oss.file.keyid}")
  public String ACCESS_KEY_ID;
  
  @Value("${aliyun.oss.file.keysecret}")
  public String ACCESS_KEY_SECRET;
  
  @Value("${aliyun.oss.file.bucketname}")
  public String BUCKET_NAME;
  
  @Override
  public Map<Object, Object> upload( MultipartFile file, String dir) {
    try{
      OSS ossClient = new OSSClientBuilder().build( END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET );
  
      String fileType =
          file.getOriginalFilename().substring( file.getOriginalFilename().lastIndexOf( "." ) );
      String fileName = UUID.randomUUID().toString().replace( "-", "" ) + fileType;
      //
      //String dataPath = new SimpleDateFormat( "yyyy/MM/dd" ).format( System.currentTimeMillis() );
      //
      //File basePath = new File( resourceFolder , dir );
      //File targetPath = new File( basePath, dataPath );
      //if( !targetPath.exists() ){
      //  targetPath.mkdirs();
      //}
      //File targetFileName = new File( targetPath, fileName );
      //multipartFile.transferTo( targetFileName );
      //获取上传文件输入流
      InputStream inputStream = file.getInputStream();
      //获取文件名称
  
      //2 把文件按照日期进行分类
      //获取当前日期
      //   2019/11/12
      String datePath = new SimpleDateFormat( "yyyy/MM/dd" ).format( System.currentTimeMillis() );
  
      //拼接
      //  2019/11/12/ewtqr313401.jpg
      fileName = datePath+"/"+fileName;
      String filePath = dir+ "/"+ fileName;
      //调用oss方法实现上传
      //第一个参数  Bucket名称
      //第二个参数  上传到oss文件路径和文件名称   aa/bb/1.jpg
      //第三个参数  上传文件输入流
      ossClient.putObject(BUCKET_NAME,filePath , inputStream);
  
      // 关闭OSSClient。
      ossClient.shutdown();
  
      //把上传之后文件路径返回
      //需要把上传到阿里云oss路径手动拼接出来
      //  https://edu-guli-1010.oss-cn-beijing.aliyuncs.com/01.jpg
      String url = "https://"+BUCKET_NAME+"."+END_POINT+"/"+filePath;
      Map<Object, Object> map = new HashMap<>();
      map.put( "url", url );
      return map;
    }catch( IOException e ){
      e.printStackTrace();
      return null;
    }
  }
}
