package org.example.juc;

import org.junit.Test;

/**
 * <h2>关键知识点</h2>
 * 1.线程/进程的执行过程、生命周期
 * 2.
 * @author liyunfei
 **/
public class ThreadSateTest {
    /**
     * Thread -->  State[enum]
     * 为什么对线程的状态定义为此种状态，来源角度CPU的调度、任务的执行
     * 对比进程调度模型以及Java抽象处理的状态（为什么去做Blocked和waiting的区别）
     * <quote>
     *  NEW ---->  START
     *              |
     *              |
     *              V
     * BLOCKED <- RUNNING ----> WAITING
     *              |
     *              |
     *              V
     *          TERMINED
     *         </quote>
     *
     * NEW ：(线程创建，分配基础内存等资源，new 对象的过程)
     * START: 分配PC指针，方法调度栈，分配值CPU被调度使用
     * RUNNING：执行任务
     * 关键理解：BLOCKED阻塞和等待WAITING---
     * 等待阻塞：加入等待队列，
     * 同步阻塞：sychronized抢锁失败，另外一个线程抢锁成功，该线程则被JVM放入 Lock Pool中
     * 其他阻塞：IO阻塞、
     *
     */
    @Test
    public void testThreadBase(){
           Thread thread = new Thread();
           Object o = new Object();

    }
}
