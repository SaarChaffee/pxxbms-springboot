package com.chaffee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaffee.entity.pojo.Bill;
import com.chaffee.service.BillService;
import com.chaffee.mapper.BillMapper;
import org.springframework.stereotype.Service;

/**
* @author RGB
* @description 针对表【bill】的数据库操作Service实现
* @createDate 2022-04-30 10:31:55
*/
@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill>
    implements BillService{

}




