package com.xiang.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author
 * @date
 * @revisionHistory
 **/
public class Homewrok05 {

    public static void main(String[] args) throws InterruptedException {
        //5 lock (需要主线程等待 保证新线程先上锁)
        ResultClass resultClass5 = new ResultClass();
        Lock lock = new ReentrantLock();
        new Thread(() -> {
            lock.lock();
            try {
                resultClass5.setResult(100);
            } finally {
                lock.unlock();
            }
        }).start();
        TimeUnit.MILLISECONDS.sleep(2000);
        lock.lock();
        try {
            System.out.println("方法5的运行结果:" + resultClass5.getResult());
        } finally {
            lock.unlock();
        }
    }


}
