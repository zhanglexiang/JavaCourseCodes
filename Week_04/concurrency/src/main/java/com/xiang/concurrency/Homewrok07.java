package com.xiang.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author
 * @date
 * @revisionHistory
 **/
public class Homewrok07 {

    public static void main(String[] args) throws InterruptedException {
        //7 Condition (需要新线程等待 保证主线程先上锁  后续等待新线程唤醒)
        AtomicInteger result7 = new AtomicInteger();
        Lock lock7 = new ReentrantLock();
        Condition condition = lock7.newCondition();
        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
                lock7.lock();
                result7.set(100);
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock7.unlock();
            }
        }).start();
        try {
            lock7.lock();
            condition.await();
            System.out.println("方法7的运行结果:" + result7.intValue());
        } finally {
            lock7.unlock();
        }
    }


}
