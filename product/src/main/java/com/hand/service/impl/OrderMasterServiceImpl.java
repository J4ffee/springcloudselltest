package com.hand.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hand.dataobject.OrderDetails;
import com.hand.dataobject.OrderMaster;
import com.hand.dataobject.ProductInfo;
import com.hand.dto.OrderMasterDto;
import com.hand.enums.ErrorStatus;
import com.hand.enums.OrderStatus;
import com.hand.enums.PayStatus;
import com.hand.exception.SellException;
import com.hand.mapper.OrderMasterMapper;
import com.hand.service.OrderDetailsService;
import com.hand.service.OrderMasterService;
import com.hand.service.ProductInfoService;
import com.hand.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jiahui.xu
 * @since 2019-03-11
 */
@Service
@Transactional
public class OrderMasterServiceImpl extends ServiceImpl<OrderMasterMapper, OrderMaster> implements OrderMasterService {
    @Autowired
    private OrderMasterMapper orderMasterMapper;
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private OrderDetailsService orderDetailsService;

    @Override
    public OrderMasterDto createOrderMaster(OrderMasterDto orderMasterDto) {
        //订单编号
        String orderId = KeyUtil.getKey();
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        //查询商品（数量，价格）
        for (OrderDetails orderDetails : orderMasterDto.getOrderDetails()) {
            ProductInfo productInfo = productInfoService.selectById(orderDetails.getProductId());
            if (productInfo == null) {
                throw new SellException(ErrorStatus.PRODUCT_NO_EXIST);
            }
            //计算订单总价
            orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetails.getProductQuantity())).add(orderAmount);
            //订单详情入库

            BeanUtils.copyProperties(productInfo, orderDetails);
            orderDetails.setOrderId(orderId);
            orderDetails.setDetailId(KeyUtil.getKey());
            orderDetailsService.insert(orderDetails);
        }
        //写入订单数据库(orderMaster)
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderMasterDto, orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMasterMapper.insert(orderMaster);
        //扣库存
        productInfoService.decreaseStock(orderMasterDto);
        orderMasterDto = new OrderMasterDto();
        orderMasterDto.setOrderId(orderId);
        return orderMasterDto;
    }

    @Override
    public OrderMasterDto findOne(String orderId) {
        OrderMasterDto orderMasterDto = orderMasterMapper.findByOrderId(orderId);
        if (orderMasterDto == null) {
            throw new SellException(ErrorStatus.ORDER_NO_EXIST);
        }
        return orderMasterDto;
    }

    @Override
    public Page<OrderMasterDto> findByBuyerOpenId(Page<OrderMasterDto> page, String buyerOpenId) {
        List ls = orderMasterMapper.findByBuyerOpenId(page, buyerOpenId);
        return page.setRecords(ls);
    }

    //取消订单
    @Override
    public OrderMasterDto cancle(OrderMasterDto orderMasterDto) {
        OrderMaster orderMaster = new OrderMaster();
        OrderMasterDto orderMasterDto1 = findOne(orderMasterDto.getOrderId());
        //判断订单状态
        if (!orderMasterDto1.getOrderStatus().equals(OrderStatus.NEW.getCode())) {
            throw new SellException(ErrorStatus.ORDER_STATUS_ERROR);
        }
        //修改订单状态
        orderMaster.setOrderId(orderMasterDto.getOrderId());
        orderMaster.setOrderStatus(OrderStatus.CANCEL.getCode());
        Integer i = orderMasterMapper.updateById(orderMaster);
        if (i == -1) {
            throw new SellException(ErrorStatus.ORDER_UPDATE_ERROR);
        }
        //返还库存
        List<OrderDetails> ls = orderMasterDto.getOrderDetails();
        if (!CollectionUtils.isEmpty(ls)) {
            productInfoService.increaseStock(orderMasterDto);
        }
        //如果已支付，需要退款
        if(orderMasterDto1.getPayStatus().equals(PayStatus.SUCCESS)){
            //TODO
        }
        return orderMasterDto;
    }

    @Override
    public OrderMasterDto finish(OrderMasterDto orderMasterDto) {
        OrderMasterDto orderMasterDto1 = findOne(orderMasterDto.getOrderId());
        //判断订单状态
        if(orderMasterDto1.getOrderStatus().equals(OrderStatus.NEW.getCode())){
            OrderMaster orderMaster = new OrderMaster();
            orderMaster.setOrderId(orderMasterDto.getOrderId());
            orderMaster.setOrderStatus(OrderStatus.FINISHED.getCode());
            orderMasterMapper.updateById(orderMaster);
        }else{
            throw new SellException(ErrorStatus.ORDER_STATUS_ERROR);
        }
        //修改订单状态
        return orderMasterDto;
    }

    @Override
    public OrderMasterDto paid(OrderMasterDto orderMasterDto) {
        //判断订单状态
        if (!orderMasterDto.getOrderStatus().equals(OrderStatus.NEW.getCode())) {
            throw new SellException(ErrorStatus.ORDER_STATUS_ERROR);
        }
        //判断支付状态
        if(orderMasterDto.getPayStatus().equals(PayStatus.WAIT)){
            throw new SellException(ErrorStatus.PAY_STATUS_ERROR);
        }
        //修改支付状态
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderMasterDto.getOrderId());
        orderMaster.setPayStatus(PayStatus.SUCCESS.getCode());
        orderMasterMapper.updateById(orderMaster);
        return null;
    }

    @Override
    public Page<OrderMasterDto>  findAll(Page<OrderMasterDto> page) {
        List<OrderMasterDto> ls = orderMasterMapper.findAll(page);
        //System.out.println("ls.size = "+ls.size());
        return page.setRecords(ls);
    }
}
