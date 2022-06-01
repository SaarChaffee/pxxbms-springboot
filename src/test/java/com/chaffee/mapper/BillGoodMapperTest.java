package com.chaffee.mapper;

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
class BillGoodMapperTest {
  @Autowired
  BillGoodMapper billGoodMapper;
  @Test
  public void queryListByBillId() {
    billGoodMapper.queryListByBillId( 8L ).forEach( System.out::println );
  }
}
