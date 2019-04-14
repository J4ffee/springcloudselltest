package com.hand.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hand.dataobject.OrderDetails;
import com.hand.mapper.OrderDetailsMapper;
import com.hand.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jiahui.xu
 * @since 2019-03-11
 */
@Service
public class OrderDetailsServiceImpl extends ServiceImpl<OrderDetailsMapper, OrderDetails> implements OrderDetailsService {
    @Autowired
    OrderDetailsMapper orderDetailsMapper;
    @Override
    public List<OrderDetails> findByOrderId(String orderId){
        return orderDetailsMapper.findByOrderId(orderId);
    }
}
