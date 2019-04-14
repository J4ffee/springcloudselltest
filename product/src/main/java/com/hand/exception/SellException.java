package com.hand.exception;

import com.hand.enums.ErrorStatus;

/**
 * @Author jiahui.xu@hand-china.com
 * @Date 2019/3/12
 */

public class SellException extends RuntimeException {
    private Integer code;
    public SellException(ErrorStatus e){
        super(e.getMessage());
        this.code = e.getCode();
    }
}
