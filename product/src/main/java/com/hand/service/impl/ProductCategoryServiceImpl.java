package com.hand.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hand.dataobject.ProductCategory;
import com.hand.mapper.ProductCategoryMapper;
import com.hand.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {
    @Autowired
    ProductCategoryMapper productCategoryMapper;
    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType) {
        return productCategoryMapper.findByCategoryTypeIn(categoryType);
    }
}
