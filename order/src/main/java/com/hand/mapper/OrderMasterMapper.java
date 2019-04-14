package com.hand.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.hand.dataobject.OrderMaster;
import com.hand.dto.OrderMasterDto;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author jiahui.xu
 * @since 2019-03-11
 */
public interface OrderMasterMapper extends BaseMapper<OrderMaster> {
    List<OrderMasterDto> findByBuyerOpenId(Pagination page, String buyerOpenId);
    OrderMasterDto findByOrderId(String orderId);
    List<OrderMasterDto> findAll(Pagination page);
}