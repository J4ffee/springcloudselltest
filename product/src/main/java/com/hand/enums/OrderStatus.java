package com.hand.enums;

/**
 * @Author jiahui.xu@hand-china.com
 * @Date 2019/1/27
 */
public enum OrderStatus {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),;
            ;
    private Integer code;
    private String message;

    OrderStatus(Integer code, String message) {
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
