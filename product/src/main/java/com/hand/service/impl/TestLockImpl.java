package com.hand.service.impl;

import com.hand.service.RedisLock;
import com.hand.service.TestLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author jiahui.xu@hand-china.com
 * @Date 2019/4/7
 */
@Service
public class TestLockImpl implements TestLock {
    //总票数
    public static int total = 1000000;
    public static int all = 1000000;
    int count = 0;
    @Autowired
    RedisLock redisLock;

    @Override
    public  String getTicket() {
        //超时时间为10秒
        long time = System.currentTimeMillis()+10*1000;
        //加锁
        if(!redisLock.lock(total+"",time+"")){
            throw new RuntimeException("出错了");
        }
        total--;
        try{
        //Thread.sleep(200);
        count++;
        //Thread.sleep(200);
            }catch (Exception e){}
        //解锁
       redisLock.unlock(total+"",time+"");
        return "总票数为="+all+"---------"+"剩余票数为"+total+"购买人数为"+count;
    }
}
