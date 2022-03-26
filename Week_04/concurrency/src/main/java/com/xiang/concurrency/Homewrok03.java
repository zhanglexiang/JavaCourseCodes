package com.xiang.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author
 * @date
 * @revisionHistory
 **/
public class Homewrok03 {
    public volatile static boolean isDone = false;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //3
        AtomicInteger result = new AtomicInteger();
        new Thread(() -> result.set(method3())).start();
        while (!isDone) {
            TimeUnit.MILLISECONDS.sleep(2000);
        }
        System.out.println("方法3的运行结果:" + result.intValue());
    }

    public static int method3 () {
        try {
            return 100;
        } finally {
            isDone = true;
        }
    }


}
