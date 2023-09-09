package com.lyf.jdkanalysis.juc.locks;

import org.junit.Test;

/**
 * @author liyunfei
 **/
public class AQSAnalysisTest {
    @Test
    public void testAQSBase(){

        // 基本概念、场景适用
        // 原子类基础：atomic,cas(usafe),sychronized,wait等，但是无法保持效率平衡
        // aqs平衡多个线程争取锁，更加有效（clh...
        // usage example:    metux,execlusive and latch
        // non-reetrantLock,..

        // 基本结构
        // Node{waitStatus,Thread}, CLH--- head,tail...;state..
        // 其实是 管理线程状态队列的CLH（协调竞争） + state（类似状态锁），，，



        // unsafe : 也可从此处看，AQS如何去使用unsafe类，如何去采用原生的原子操作，保证并发安全
        // lockSupport
        // 保证CLH入队和出队以及同步更改  state
        // private static final Unsafe unsafe =  Unsafe.getUnsafe();
        /**
         * Atomically sets synchronization state to the given updated
         * value if the current state value equals the expected value.
         * This operation has memory semantics of a <tt>volatile</tt> read
         * and write.
         * @param expect the expected value
         * @param update the new value
         * @return true if successful. False return indicates that
         * the actual value was not equal to the expected value.
         */
//        protected final boolean compareAndSetState(int expect, int update) {
//            // See below for intrinsics setup to support this
//            return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
//        }


    }
}
