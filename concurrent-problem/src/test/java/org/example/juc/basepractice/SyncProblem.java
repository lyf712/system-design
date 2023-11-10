package org.example.juc.basepractice;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步问题
 * 1.顺序保证-- 交替打印ABC
 * 2
 * @author liyunfei
 **/
public class SyncProblem {

    /***
     * test1.
     * 10个线程，任务队列。
     * 线程按照顺序执行任务，5s处理一个任务，若任务队列里面超过100个则进行1s一个处理
     * 本质：生产消费者问题
     */


    private static class CounterIndex{
        private int index = 0;
        int getIndex(){return index;}
        void add(){index++;if(index>10){index=0;}}
    }
    static CounterIndex index = new CounterIndex();
    static Lock lock = new ReentrantLock();

    @Test
    public void test1(){
        //BlockingQueue<Task> tasks = new ArrayBlockingQueue<>(1);

        TaskDB taskDB = new TaskDB();


        Thread thread = new Thread(()->{
            Long id = 0L;
            for(;;){
                try {
                    TimeUnit.SECONDS.sleep(1+new Random().nextInt(3));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Task task = new Task(id++);
                System.out.println(String.format("生产Task %d",task.getId()));
                taskDB.addTask(task);
            }
        });//.start();

        thread.start();

        Handler[] handlers = new Handler[10];
        //
        Thread[]threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            handlers[i] =new Handler(i,taskDB);
            // thread可以多个对应handler,000该种实现还是不太好
            threads[i]=new Thread(handlers[i]);
        }
        for (Thread thread1 : threads) {
            thread1.start();
        }

        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            thread.interrupt();
            for (Thread handler : threads) {
                handler.interrupt();
            }
        }
    }

    private static class Handler implements Runnable{

        private final int indexNo;

        private final TaskDB taskDB;

        public Handler(int indexNo, TaskDB taskDB) {
            this.indexNo = indexNo;
            this.taskDB = taskDB;
        }

        @Override
        public void run() {
            lock.lock();
            if(indexNo==index.getIndex()){
                handle(taskDB);
                index.add();
            }
            lock.unlock();
        }

        void handle(TaskDB taskDB){
            if(taskDB.getSize()>=100){
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Task task = taskDB.handleTask();
                System.out.printf("handler-%d handler task-%d%n",indexNo, task.getId());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    // 任务资源管理
    private static class TaskDB{
        private final ArrayBlockingQueue<Task> blockingDeque = new ArrayBlockingQueue<Task>(150);
        void addTask(Task task){
            blockingDeque.add(task);
        }
        Task handleTask() throws InterruptedException {
           return blockingDeque.take();
        }
        int getSize(){
            return blockingDeque.size();
        }
    }

    private static class Task{

        private final Long id;

        public Task(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }


}
