package com.hand.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.hand.dataobject.OrderMaster;
import com.hand.dto.OrderMasterDto;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jiahui.xu
 * @since 2019-03-11
 */
public interface OrderMasterService extends IService<OrderMaster> {

	//创建订单
    OrderMasterDto createOrderMaster(OrderMasterDto orderMasterDto);
    //查询单个订单
    OrderMasterDto findOne(String orderId);
    //查询订单列表
    Page<OrderMasterDto> findByBuyerOpenId(Page<OrderMasterDto> page, String buyerOpenId);
    //取消订单
    OrderMasterDto  cancle(OrderMasterDto orderMasterDto);
    //完结订单
    OrderMasterDto finish(OrderMasterDto orderMasterDto);
    //支付订单
    OrderMasterDto paid(OrderMasterDto orderMasterDto);
    //查询所有订单
    Page<OrderMasterDto>  findAll(Page<OrderMasterDto> page);
}
