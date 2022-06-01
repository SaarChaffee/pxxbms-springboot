package com.chaffee.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaffee.entity.vo.BillVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/31
 */
@SpringBootTest
class BillMapperTest {
  @Autowired
  BillMapper billMapper;
  
  @Test
  public void queryBillList() {
    Page<BillVO> page = new Page<BillVO>( 1, 15 );
    billMapper.queryBillList( page, "",  0L ).forEach( System.out::println );
    
  }
}
