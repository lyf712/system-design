package org.example;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 **/
public class ThreadPoolTest {
    @Test
    public void testThreadExecutor(){
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(@NotNull Runnable r) {
                Thread thread = new Thread(r);
                r.run();
                return thread;
            }
        };
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(5);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                5,9,60, TimeUnit.SECONDS,
                queue,new ThreadPoolExecutor.AbortPolicy());
        // 测试理解 七个参数的作用，关键理解 core,max,keepAlive,queue,handler
        for(int i=0;i<16;i++){
            int finalI = i;
            poolExecutor.execute(()->{
                System.out.println("ok-"+ finalI);
                //java.util.concurrent.RejectedExecutionException: Task org.example.pool.ThreadPoolAnalysis$$Lambda$1/707806938@574caa3f rejected from java.util.concurrent.ThreadPoolExecutor@64cee07
                // [Running, pool size = 9, active threads = 9, queued tasks = 5, completed tasks = 0]
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            // 需要去评估 任务的执行时间和提交频率，来设置参数
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(poolExecutor.getPoolSize()+":"+queue.size());
        }
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
    }
    @Test
    public void testExecuteProcess(){

    }
    @Test
    public void testHandler(){

    }
}
