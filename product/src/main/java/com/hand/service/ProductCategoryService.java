package com.hand.service;

import com.baomidou.mybatisplus.service.IService;
import com.hand.dataobject.ProductCategory;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jiahui.xu
 * @since 2019-03-11
 */
public interface ProductCategoryService extends IService<ProductCategory> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);
}
