package com.hand.VO;

import java.io.Serializable;

/**http请求返回的最外层对象
 * @Author jiahui.xu@hand-china.com
 * @Date 2019/1/9
 */
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -2718340371329954409L;
    //错误码
    private Integer code;
    //提示信息
    private String message;
    //返回内容
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
