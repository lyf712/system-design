package com.lyf.jdkanalysis.juc.locks.practice;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liyunfei
 **/
public class TicketService {
    // 标志位，不能单独做锁,,,,可通过volatile和原子性这些状态去标识共享状态
    // 但具体的线程状态需要locksupport,thread.wait,等去控制保证
    // sychronized则有对象锁池
    private AtomicBoolean lock1 = new AtomicBoolean(false);
    private ReentrantLock lock2 = new ReentrantLock();
    //TicketDao ticketDao = new TicketDao();
    public synchronized void decrease1(){
           TicketDao.ticketRepo.decrease();
    }
    public void decrease2(){
//          while (lock1.compareAndSet(false,true)){
//              TicketDao.ticketRepo.decrease();
//          }
    }

    public void decrease3(){
        lock2.lock();
        try {
            TicketDao.ticketRepo.decrease();
        }finally {
            lock2.unlock();
        }
    }

}
