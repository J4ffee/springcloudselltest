package com.hand.dataobject;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * @Author jiahui.xu@hand-china.com
 * @Date 2019/4/2
 */
@TableName("seller_info")
public class SellerInfo implements Serializable {

    private static final long serialVersionUID = 1901299777416192601L;
    @TableId(value = "seller_id")
    private String sellerId;
    private String username;
    private String password;

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
