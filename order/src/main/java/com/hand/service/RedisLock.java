package com.hand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author jiahui.xu@hand-china.com
 * @Date 2019/4/7
 */
@Component
public class RedisLock {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 加锁
     *
     * @param key
     * @param value 当前时间+超时时间
     * @return
     */
    public boolean lock(String key, String value) {
        if (stringRedisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }
        String currentValue = stringRedisTemplate.opsForValue().get(key);
        //如果锁过期
        if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {//currentValue不为空且小于当前时间
            //获取上一个锁的时间value
            String oldValue = stringRedisTemplate.opsForValue().getAndSet(key, value);//对应getset，如果key存在

            //假设两个线程同时进来这里，因为key被占用了，而且锁过期了。获取的值currentValue=A(get取的旧的值肯定是一样的),两个线程的value都是B,key都是K.锁时间已经过期了。
            //而这里面的getAndSet一次只会一个执行，也就是一个执行之后，上一个的value已经变成了B。只有一个线程获取的上一个值会是A，另一个线程拿到的值是B。
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                //oldValue不为空且oldValue等于currentValue，也就是校验是不是上个对应的商品时间戳，也是防止并发
                return true;
            }
        }


        return false;
    }

    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key,String value){
        String currentValue = stringRedisTemplate.opsForValue().get(key);
        try {
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                stringRedisTemplate.opsForValue().getOperations().delete(key);
            }
        }catch (Exception e){
            System.out.println("出异常了");
        }
    }
}
