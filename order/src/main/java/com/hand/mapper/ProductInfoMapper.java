package com.hand.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hand.dataobject.ProductInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jiahui.xu
 * @since 2019-03-11
 */
public interface ProductInfoMapper extends BaseMapper<ProductInfo> {
    List<ProductInfo> getInfoByStatus(Integer status);
    void increaseStock(@Param("num") Integer num, @Param("productId") String productId);
    void decreaseStock(@Param("num") Integer num, @Param("productId") String productId);
}