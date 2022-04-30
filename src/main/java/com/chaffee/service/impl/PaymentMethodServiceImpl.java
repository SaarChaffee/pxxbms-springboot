package com.chaffee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaffee.entity.pojo.PaymentMethod;
import com.chaffee.service.PaymentMethodService;
import com.chaffee.mapper.PaymentMethodMapper;
import org.springframework.stereotype.Service;

/**
* @author RGB
* @description 针对表【payment_method】的数据库操作Service实现
* @createDate 2022-04-30 10:31:55
*/
@Service
public class PaymentMethodServiceImpl extends ServiceImpl<PaymentMethodMapper, PaymentMethod>
    implements PaymentMethodService{

}




