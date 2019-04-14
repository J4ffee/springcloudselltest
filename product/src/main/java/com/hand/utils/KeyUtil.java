package com.hand.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * @Author jiahui.xu@hand-china.com
 * @Date 2019/3/12
 */

public class KeyUtil {
    /**
     * 生成唯一接口
     * @return
     */
    public static String getKey(){
            String uuid = UUID.randomUUID().toString();
            return uuid;
    }
    @Test
    public void test(){
        System.out.println(getKey());
        System.out.println(getKey().length());
    }
}
