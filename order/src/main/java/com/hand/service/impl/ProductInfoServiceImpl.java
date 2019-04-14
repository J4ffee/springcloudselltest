package com.hand.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hand.dataobject.OrderDetails;
import com.hand.dataobject.ProductInfo;
import com.hand.dto.OrderMasterDto;
import com.hand.enums.ErrorStatus;
import com.hand.exception.SellException;
import com.hand.mapper.ProductInfoMapper;
import com.hand.service.ProductInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jiahui.xu
 * @since 2019-03-11
 */
@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfo> implements ProductInfoService {
    @Resource
    ProductInfoMapper productInfoMapper;

    @Override
    public List<ProductInfo> getInfoByStatus(Integer productStatus ) {
        return productInfoMapper.getInfoByStatus(productStatus);
    }

    /**
     *加库存
     * @param orderMasterDto
     */
    @Override
    public void increaseStock(OrderMasterDto orderMasterDto) {
        List<OrderDetails> ls = orderMasterDto.getOrderDetails();
        for (OrderDetails orderDetails:ls){
            String productId =  orderDetails.getProductId();
            Integer productQuantity = orderDetails.getProductQuantity();
            productInfoMapper.increaseStock(productQuantity,productId);
        }

    }

    /**
     * 减库存
     * @param orderMasterDto
     */
    @Override
    public void decreaseStock(OrderMasterDto orderMasterDto) {
        List<OrderDetails> ls = orderMasterDto.getOrderDetails();
        for (OrderDetails orderDetails:ls){
            String productId =  orderDetails.getProductId();
            Integer productQuantity = orderDetails.getProductQuantity();
            ProductInfo productInfo = productInfoMapper.selectById(productId);
            //获得库存
            Integer productQuantityInDb = productInfo.getProductStock();
            if(productQuantity>productQuantityInDb){
                throw new SellException(ErrorStatus.PRODUCT_NOT_ENOUGH);
            }
            productInfoMapper.decreaseStock(productQuantity,productId);
        }

    }


}
