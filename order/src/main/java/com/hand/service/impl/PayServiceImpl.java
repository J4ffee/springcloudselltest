package com.hand.service.impl;

import com.hand.dataobject.OrderMaster;
import com.hand.dto.OrderMasterDto;
import com.hand.mapper.OrderMasterMapper;
import com.hand.service.PayService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author jiahui.xu@hand-china.com
 * @Date 2019/3/25
 */
@Service
public class PayServiceImpl implements PayService {
    @Autowired
    OrderMasterMapper orderMasterMapper;
    @Override
    public void create(OrderMasterDto orderMasterDto) {
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderMasterDto,orderMaster);
        orderMasterMapper.updateById(orderMaster);
        System.out.println("支付成功");
        //TODO
    }
}
