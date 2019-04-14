package com.hand.enums;

/**
 * @Author jiahui.xu@hand-china.com
 * @Date 2019/3/12
 */

public enum ErrorStatus {
    PRODUCT_NO_EXIST(10, "商品不存在"),
    PRODUCT_NOT_ENOUGH(20,"库存不够"),
    ORDER_NO_EXIST(30,"订单不存在"),
    ORDER_STATUS_ERROR(40,"订单状态错误"),
    ORDER_UPDATE_ERROR(50,"订单更新错误"),
    PAY_STATUS_ERROR(60,"支付状态错误"),
    PARAM_ERROR(1,"参数不正确"),
    LOGIN_ERROR(70,"用户名或密码错误"),
    NO_COOKIE(80,"cookie中找不到token值"),
    ERROR_SHOW(101,"出错了")
    ;
    Integer code;
    String message;

    ErrorStatus(Integer code, String message) {
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
    }}
