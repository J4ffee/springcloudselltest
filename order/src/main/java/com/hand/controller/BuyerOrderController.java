package com.hand.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.hand.VO.ResultVO;
import com.hand.convent.OrderMasterForm2OrderMasterDto;
import com.hand.dataobject.OrderDetails;
import com.hand.dto.OrderMasterDto;
import com.hand.enums.ErrorStatus;
import com.hand.exception.SellException;
import com.hand.form.OrderMasterForm;
import com.hand.service.OrderMasterService;
import com.hand.utils.ResultVoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author jiahui.xu@hand-china.com
 * @Date 2019/3/12
 */
@Controller
@RequestMapping("/buyer/order")
public class BuyerOrderController {
    @Autowired
    private OrderMasterService orderMasterService;
    //创建订单
    @RequestMapping("/create")
    @ResponseBody
    public ResultVO create(@Valid OrderMasterForm orderMasterForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new SellException(ErrorStatus.PARAM_ERROR);
        }
        OrderMasterDto orderMasterDto = OrderMasterForm2OrderMasterDto.convert2OrderMasterDto(orderMasterForm);
        OrderMasterDto orderMasterDto1 = orderMasterService.createOrderMaster(orderMasterDto);
        return ResultVoUtil.success(orderMasterDto1);
    }
    //订单列表
    @RequestMapping("/list")
    @ResponseBody
    public ResultVO<List<OrderDetails>> list(@RequestParam("openid") String openid,@RequestParam(value = "page",defaultValue = "0") Integer pagenum,@RequestParam(value = "size",defaultValue = "10") Integer size){
        if(StringUtils.isEmpty(openid)){
            throw new SellException(ErrorStatus.PARAM_ERROR);
        }
        Page<OrderMasterDto> page = new Page<>(pagenum,size);
        Page<OrderMasterDto> result= orderMasterService.findByBuyerOpenId(page,openid);
        List<OrderMasterDto> orderMasterDto = result.getRecords();
        return ResultVoUtil.success(orderMasterDto);
    }
    //订单详情
    @RequestMapping("/getOrderDetails")
    @ResponseBody
    public ResultVO getOrderDetails(@RequestParam("openid") String openid,@RequestParam("orderId") String orderId){
       OrderMasterDto orderMasterDto = orderMasterService.findOne(orderId);
       return ResultVoUtil.success(orderMasterDto);
    }
    //取消订单
    @RequestMapping("/cancel")
    @ResponseBody
    public ResultVO cancel(@RequestParam("openid") String openid,@RequestParam("orderId") String orderId){
        OrderMasterDto orderMasterDto = new OrderMasterDto();
        orderMasterDto.setOrderId(orderId);
        orderMasterDto = orderMasterService.cancle(orderMasterDto);
        return ResultVoUtil.success(orderMasterDto);
    }
}
