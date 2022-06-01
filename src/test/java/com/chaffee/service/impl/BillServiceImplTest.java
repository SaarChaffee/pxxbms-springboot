package com.chaffee.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chaffee.entity.vo.BillVO;
import com.chaffee.service.BillService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Name: pxxbms-springboot
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2022 2022/5/31
 */
@SpringBootTest
class BillServiceImplTest {
  @Autowired
  BillService billService;
  @Test
  public void queryBillList() {
    Page<BillVO> page = new Page<BillVO>( 1, 15 );
    billService.queryBillList( page,"",0L ).forEach( System.out::println );
  }
}
