package com.qunar.learning;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author : jiabin.niu
 **/
public class CallableAndFuture {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(threadPool);
        for (int i = 0; i < 10; i++) {
            final int seq = i;
            System.out.println("开始提交" + seq + "个任务");
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));
                    return seq;
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            try {
                Integer seq = completionService.take().get();
                System.out.println("第" + seq + "个任务返回");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
