package com.hand.enums;

/**
 * 商品状态
 *
 * @Author jiahui.xu@hand-china.com
 * @Date 2019/1/9
 */
public enum ProductStatus {
    up(0,"下架"),
    down(1,"上架")
    ;
    private Integer code;
    private String message;

    ProductStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
