package com.xiang.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author
 * @date
 * @revisionHistory
 **/
public class Homewrok06 {

    public static void main(String[] args) throws InterruptedException {
        //6 Semaphore (需要主线程等待 保证新线程先上锁)
        AtomicInteger result6 = new AtomicInteger();
        Semaphore singleSemaphore = new Semaphore(1);
        new Thread(() -> {
            try {
                singleSemaphore.acquireUninterruptibly();
                result6.set(100);
            } finally {
                singleSemaphore.release();
            }
        }).start();
        TimeUnit.MILLISECONDS.sleep(2000);
        try {
            singleSemaphore.acquireUninterruptibly();
            System.out.println("方法6的运行结果:" + result6.intValue());
        } finally {
            singleSemaphore.release();
        }
    }


}
