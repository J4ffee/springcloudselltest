package com.hand.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.hand.dataobject.ProductInfo;
import com.hand.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author jiahui.xu@hand-china.com
 * @Date 2019/4/2
 */
@Controller
@RequestMapping("/seller/product")
public class SellerProductController {
    @Autowired
    ProductInfoService productInfoService;
    @GetMapping("list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "size" ,defaultValue = "2") Integer size, Map<String,Object> map){
        Page<ProductInfo> pageInfo = new Page(page,size);
        Page<ProductInfo> productInfo = productInfoService.selectPage(pageInfo);
        map.put("size",productInfo.getSize());
        map.put("productInfo",productInfo.getRecords());
        return new ModelAndView("product/list",map);
    }
}
