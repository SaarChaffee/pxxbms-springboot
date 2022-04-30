package com.chaffee.mapper;

import com.chaffee.entity.pojo.PaymentMethod;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author RGB
* @description 针对表【payment_method】的数据库操作Mapper
* @createDate 2022-04-30 10:31:55
* @Entity PaymentMethod
*/
@Mapper
public interface PaymentMethodMapper extends BaseMapper<PaymentMethod> {

}




