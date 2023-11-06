package org.example.thread;

import java.sql.Time;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author liyunfei
 **/
public class ThreadTests {
    final static ThreadLocal<Integer> counter = ThreadLocal.withInitial(()-> 1);

    //new ThreadLocal<>();

    final static ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>(16);

    public static void main(String[] args) {
        Thread[]threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threads[i] = new Thread(()->{
                if(finalI ==5){
                    Thread.yield();
                }
                counter.set(counter.get()+1);
                map.put(Thread.currentThread().getName(),counter.get()+":"+System.currentTimeMillis());
            },"thread-"+i);
            threads[i].start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        map.forEach((k,v)->{
            System.out.printf("%s,%s \n",k,v);
        });
    }

    private static class Task implements Runnable{
        @Override
        public void run() {
            //for(int i)
        }
    }

}
