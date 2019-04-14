package com.hand.VO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 商品（包含类目）
 *
 * @Author jiahui.xu@hand-china.com
 * @Date 2019/1/9
 */

public class ProductVO implements Serializable {

    private static final long serialVersionUID = -6396516177832778416L;
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> ls;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public List<ProductInfoVO> getLs() {
        return ls;
    }

    public void setLs(List<ProductInfoVO> ls) {
        this.ls = ls;
    }
}
