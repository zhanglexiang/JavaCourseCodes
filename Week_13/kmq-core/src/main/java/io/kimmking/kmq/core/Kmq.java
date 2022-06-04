package io.kimmking.kmq.core;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class Kmq {

    public Kmq(String topic) {
        this.topic = topic;
        this.queue = new KmqMessage[10000];
    }

    private String topic;

    private int offset;

    private int commitOffset;

    private KmqMessage[] queue;

    public boolean send(KmqMessage message) {
        queue[commitOffset] = message;
        commitOffset++;
        return true;
    }

    public KmqMessage poll() {
        if(queue.length > offset){
            KmqMessage kmqMessages = queue[offset];
            if(kmqMessages != null){
                offset++;
            }
            return kmqMessages;
        }else{
            return null;
        }
    }

    @SneakyThrows
    public KmqMessage poll(long timeout) {
        KmqMessage kmqMessages = null;
        if(queue.length > offset){
            kmqMessages = queue[offset];
        }
        if(kmqMessages != null){
            offset++;
        }else{
            try{
                Thread.sleep(timeout);
            }catch (Exception e){

            }
            if(queue.length > offset){
                kmqMessages = queue[offset];
                if(kmqMessages != null){
                    offset++;
                }
            }else{
                throw new RuntimeException();
            }
        }
        return kmqMessages;

    }

}
