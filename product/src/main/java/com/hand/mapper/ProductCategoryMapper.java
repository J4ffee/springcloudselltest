package com.hand.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hand.dataobject.ProductCategory;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author jiahui.xu
 * @since 2019-03-11
 */
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);
}