package com.xiang.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @date
 * @revisionHistory
 **/
public class Homewrok04 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //4 synchronized (需要主线程等待 保证新线程锁住对象)
        ResultClass resultClass = new ResultClass();
        new Thread(() -> {
            synchronized (resultClass) {
                resultClass.setResult(100);
            }
        }).start();
        TimeUnit.MILLISECONDS.sleep(2000);
        synchronized(resultClass) {
            System.out.println("方法4的运行结果:" + resultClass.getResult());
        }
    }


}
