package com.hand.service;

import com.baomidou.mybatisplus.service.IService;
import com.hand.dataobject.ProductInfo;
import com.hand.dto.OrderMasterDto;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jiahui.xu
 * @since 2019-03-11
 */
public interface ProductInfoService extends IService<ProductInfo> {
	List<ProductInfo> getInfoByStatus(Integer productStatus);
	//加库存
	void increaseStock(OrderMasterDto orderMasterDto);
	//减库存
	void decreaseStock(OrderMasterDto orderMasterDto);
}
