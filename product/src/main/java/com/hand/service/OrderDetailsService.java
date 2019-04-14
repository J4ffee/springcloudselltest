package com.hand.service;

import com.baomidou.mybatisplus.service.IService;
import com.hand.dataobject.OrderDetails;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jiahui.xu
 * @since 2019-03-11
 */
public interface OrderDetailsService extends IService<OrderDetails> {
    List<OrderDetails> findByOrderId(String orderId);
}
