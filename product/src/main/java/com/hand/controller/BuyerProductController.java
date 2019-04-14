package com.hand.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.hand.VO.ProductInfoVO;
import com.hand.VO.ProductVO;
import com.hand.VO.ResultVO;
import com.hand.dataobject.ProductCategory;
import com.hand.dataobject.ProductInfo;
import com.hand.dto.OrderMasterDto;
import com.hand.service.OrderMasterService;
import com.hand.service.ProductCategoryService;
import com.hand.service.ProductInfoService;
import com.hand.utils.ResultVoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**买家商品
 * @Author jiahui.xu@hand-china.com
 * @Date 2019/1/9
 */
@Controller
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private OrderMasterService orderMasterService;
    @RequestMapping("/list")
    @ResponseBody
    @Cacheable(cacheNames = "product",key = "123")
    public ResultVO list(){
        System.out.println("this is list");
        //1.查询所有的上架的商品
        List<ProductInfo> productInfos = productInfoService.getInfoByStatus(0);

        //2.查询类目（一次性查询）
        List<Integer> categoryTypeList = new ArrayList<>();
        for ( ProductInfo p : productInfos) {
            categoryTypeList.add(p.getCategoryType());
        }
        List<ProductCategory> ls = productCategoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory p : ls) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(p.getCategoryType());
            productVO.setCategoryName(p.getCategoryName());
            List<ProductInfoVO> lsp = new ArrayList<>();
            for (ProductInfo pd: productInfos) {
                if(p.getCategoryType().equals(pd.getCategoryType())){
                    ProductInfoVO piv = new ProductInfoVO();
                    BeanUtils.copyProperties(pd,piv);
                    lsp.add(piv);
                }
            }
            productVO.setLs(lsp);
            productVOList.add(productVO);
        }
        return ResultVoUtil.success(productVOList);
    }
    @RequestMapping("/findByBuyerOpenId")
    @ResponseBody
    public ResultVO findByBuyerOpenId(){
        Page<OrderMasterDto> page = new Page<OrderMasterDto>(2,2);
        Page page1 = orderMasterService.findByBuyerOpenId(page,"1234");
        List<OrderMasterDto> ls = page.getRecords();
        return ResultVoUtil.success(ls);
    }

    @GetMapping("/listForOrder")
    @ResponseBody
    public ProductInfo listForOrder(@RequestParam("id") String id){
         return productInfoService.selectById(id);
    }

    @PostMapping("/decreaseStock")
    @ResponseBody
    public void decreaseStock(@RequestBody OrderMasterDto orderMasterDto){
        productInfoService.decreaseStock(orderMasterDto);
    }
}
