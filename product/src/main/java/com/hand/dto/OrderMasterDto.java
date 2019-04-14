package com.hand.dto;

import com.hand.dataobject.OrderDetails;
import com.hand.dataobject.OrderMaster;

import java.util.List;

/**
 * @Author jiahui.xu@hand-china.com
 * @Date 2019/3/11
 */

public class OrderMasterDto extends OrderMaster {
    List<OrderDetails> orderDetails;

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    
}
