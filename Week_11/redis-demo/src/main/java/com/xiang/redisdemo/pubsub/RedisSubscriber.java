package com.xiang.redisdemo.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

/**
* Redis PubSub 消费者
* 
*/
@Component
public class RedisSubscriber extends MessageListenerAdapter {

    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println("监听到生产者发送的消息: " + message);
    }

}
