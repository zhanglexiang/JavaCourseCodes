package com.xiang.concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * @author
 * @date
 * @revisionHistory
 **/
public class Homewrok01 {

    public static void main(String[] args) throws InterruptedException {
        //1  CountDownLatch
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatchTask latchTask = new CountDownLatchTask(countDownLatch);
        new Thread(latchTask).start();
        countDownLatch.await();
        System.out.println("方法1的运行结果:" + latchTask.getResult());
    }


}
