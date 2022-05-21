package com.xiang.redisdemo;

import com.xiang.redisdemo.utils.DistributedRedisLock;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author
 * @date
 * @revisionHistory
 **/
@Slf4j
@SpringBootTest
public class RedisTest {

    private final String LOCK = "LOCK";

    // 商品库存
    private final String INVENTORY = "INVENTORY";

    @Autowired
    private DistributedRedisLock distributedRedisLock;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    /*** 
     * 简单的分布式锁
     * @author zl 
     * @date 5/21/22 12:40 PM 
     */
    @Test
    public void redissionLockTest() {
        try {
            if (distributedRedisLock.lock(LOCK)) {
                // 业务逻辑
                log.info("开始业务逻辑");
            } else {
                // 处理获取锁失败的逻辑
                log.info("获取锁失败");
            }
        } catch (Exception e) {
            log.error("处理异常：", e);
        } finally {
            log.info("释放锁");
            distributedRedisLock.unlock(LOCK);
        }
    }


    /***
     * 分布式计数器，模拟减库存
     * @author zl
     * @date 5/21/22 12:40 PM
     */
    @Test
    public void counterTest() {
        // 减掉2个库存
        Long counter = redisTemplate.opsForValue().decrement(INVENTORY, 2);
        log.info("counter: {}", counter);
    }


    /*** 
     * 发布消息
     * @author zl 
     * @date 5/21/22 12:55 PM 
     */
    @Test
    public void publish() {
        redisTemplate.convertAndSend("java.news", "hello java?");
        redisTemplate.convertAndSend("java.news", "let's learn java everyday!!");
        redisTemplate.convertAndSend("java.news", "easy java 3.7");
    }



}
