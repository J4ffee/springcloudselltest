package com.hand.client;

import com.hand.dataobject.ProductInfo;
import com.hand.dto.OrderMasterDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author jiahui.xu@hand-china.com
 * @Date 2019/4/14
 */
@FeignClient(name = "product")
public interface ProductClient {
    @GetMapping("/msg")
    String getMsg();
    @GetMapping("/buyer/product/listForOrder")
    ProductInfo listForOrder(@RequestParam("id") String id);
    @PostMapping("/buyer/product/decreaseStock")
    void decreaseStock(OrderMasterDto orderMasterDto);

}
