package com.hand.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.hand.dataobject.OrderMaster;
import com.hand.dto.OrderMasterDto;
import com.hand.exception.SellException;
import com.hand.service.OrderMasterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 卖家端订单
 *
 * @Author jiahui.xu@hand-china.com
 * @Date 2019/3/26
 */
@Controller
@RequestMapping("/seller/order")
public class SellerOrderController {
    @Autowired
    private OrderMasterService orderMasterService;

    /**
     * 查询订单
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "size" ,defaultValue = "2") Integer size, Map<String,Object> map) {
        Page<OrderMaster> pageInfo = new Page(page,size);
        System.out.println("this is list");
        //Page page1 = orderMasterService.findAll(pageInfo);
        //获取订单列表
        Page<OrderMaster> orderInfo = orderMasterService.selectPage(pageInfo);
        //所有订单信息
        List ls = orderInfo.getRecords();
        //订单总页数
        long pages = orderInfo.getPages();

        map.put("orderInfo",orderInfo.getRecords());
        map.put("pages",pages);
        map.put("currentPage",page);
        return new ModelAndView("order/list",map);

    }

    /**
     * 取消订单
     * @return
     */
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,@RequestParam(value = "page",defaultValue = "1") int page,Map<String,Object> map){
        OrderMasterDto orderMasterDto = new OrderMasterDto();
        orderMasterDto.setOrderId(orderId);
        try {
            orderMasterService.cancle(orderMasterDto);
        }catch (SellException e){
            String message = e.getMessage();
            map.put("message",message);
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        map.put("message","取消成功");
        map.put("url","/sell/seller/order/list?page="+page);
        return new ModelAndView("order/success");
    }

    /**
     * 订单详情
     * @return
     */
    @GetMapping("/details")
    public ModelAndView detail(@RequestParam("orderId") String orderId,@RequestParam("page") int page,Map<String,Object> map){
        OrderMasterDto orderMasterDto=null;
        try{
        orderMasterDto = orderMasterService.findOne(orderId);}
        catch (SellException e){
            map.put("message",e.getMessage());
            map.put("url","/sell/seller/order/list?page="+page);
            return new ModelAndView("common/error",map);
        }
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderMasterDto,orderMaster);
        List ls = orderMasterDto.getOrderDetails();
        map.put("details",ls);
        map.put("currentPage",page);
        map.put("orderMaster",orderMaster);
        return new ModelAndView("order/detail",map);

    }
    /**
     * 完结订单
     */
    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId,@RequestParam("page") int page,Map<String,Object> map){
        OrderMasterDto orderMasterDto = new OrderMasterDto();
        orderMasterDto.setOrderId(orderId);
        try{
        orderMasterService.finish(orderMasterDto);}
        catch (SellException e){
            map.put("message",e.getMessage());
            map.put("url","/sell/seller/order/details?orderId="+orderId+"&page="+page);
            return new ModelAndView("common/error",map);
        }
        map.put("message","成功");
        map.put("url","/sell/seller/order/details?orderId="+orderId+"&page="+page);
        return new ModelAndView("order/success",map);
    }
}
