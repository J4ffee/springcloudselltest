package com.hand.convent;

import com.alibaba.fastjson.JSONObject;
import com.hand.dataobject.OrderDetails;
import com.hand.dto.OrderMasterDto;
import com.hand.form.OrderMasterForm;

import java.util.List;

/**
 * @Author jiahui.xu@hand-china.com
 * @Date 2019/3/13
 */

public class OrderMasterForm2OrderMasterDto {
    public static OrderMasterDto convert2OrderMasterDto(OrderMasterForm orderMasterForm){
        OrderMasterDto orderMasterDto = new OrderMasterDto();
        orderMasterDto.setBuyerName(orderMasterForm.getName());
        orderMasterDto.setBuyerAddress(orderMasterForm.getAddress());
        orderMasterDto.setBuyerPhone(orderMasterForm.getPhone());
        orderMasterDto.setBuyerOpenid(orderMasterForm.getOpenid());
        String itemString = orderMasterForm.getItems();
        List<OrderDetails> orderDetails = JSONObject.parseArray(itemString, OrderDetails.class);
        orderMasterDto.setOrderDetails(orderDetails);
        return orderMasterDto;
    }
}
