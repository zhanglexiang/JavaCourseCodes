package com.xiang.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @date
 * @revisionHistory
 **/
public class Homewrok02 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //2  FutureTask
        FutureTask<Integer> task = new FutureTask<>(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        new Thread(task).start();
        while (!task.isDone()) {
            TimeUnit.MILLISECONDS.sleep(2000);
        }
        System.out.println("方法2的运行结果:" + task.get());
    }


}
