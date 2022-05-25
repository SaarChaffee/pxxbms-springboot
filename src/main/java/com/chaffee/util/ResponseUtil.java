/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/25
 */
package com.chaffee.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class ResponseUtil {
  public static void out( HttpServletResponse response, R result ) {
    ObjectMapper mapper = new ObjectMapper();
    PrintWriter out = null;
    response.setStatus( HttpStatus.OK.value() );
    response.setContentType( MediaType.APPLICATION_JSON_UTF8_VALUE );
    try{
      out = response.getWriter();
      mapper.writeValue( out, result );
    }catch( Exception e ){
      e.printStackTrace();
    }finally{
      out.flush();
      out.close();
    }
  }
}
