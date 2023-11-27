package com.lyf.jdkanalysis.juc.unsafe;

import lombok.Data;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * 基本介绍：<a href="https://blog.csdn.net/qq_45609369/article/details/132149845">大致介绍相关API</a>
 *
 * 1.关键理解：offset的理解
 * 2.内存的管理的基础知识：C++相关基础操作 alloc,free等-- 其实就是对C++JDK操作硬件内存时的上层封装
 *
 * @author liyunfei
 **/
public class UnsafeTests {

    Unsafe getUnsafe(){
        //  反射方式
        Class<?> unsafeClazz = Unsafe.class;
        try {
            Field theUnsafe = unsafeClazz.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Object o = theUnsafe.get(null);
            return  (Unsafe)o;
            // ((Unsafe) o).putAddress();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 构造创建
     */
    @Test
    public void test1(){
        // 静态方法，单例模式获取
        /// Exception in thread "main" java.lang.SecurityException: Unsafe 类加载器回顾
        //Unsafe unsafe = Unsafe.getUnsafe();

        //  反射方式
        Class<?> unsafeClazz = Unsafe.class;
        try {
            Field theUnsafe = unsafeClazz.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Object o = theUnsafe.get(null);
            o = (Unsafe)o;
            // ((Unsafe) o).putAddress();


        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * 偏移量的理解
     * to see:
     * 1.CopyOnwriteList
     * 2.LockSupport
     * 3.CompleteFuture
     * 大量应用——————
     */
    @Test
    public void test2(){
        Unsafe unsafe = getUnsafe();//Unsafe.getUnsafe();
        UnsafeTestClazz unsafeTestObj = new UnsafeTestClazz();
        //unsafeTestObj.setName("lyf_coding");
        unsafeTestObj.setValue(24);
        try {
            // 都是 4个偏移量？
            long valueOffset = unsafe.objectFieldOffset(unsafeTestObj.getClass().getDeclaredField("value"));
            long nameOffset = unsafe.objectFieldOffset(unsafeTestObj.getClass().getDeclaredField("name"));
            long longValueOffset = unsafe.objectFieldOffset(unsafeTestObj.getClass().getDeclaredField("longValue"));
            long byteValueOffset = unsafe.objectFieldOffset(unsafeTestObj.getClass().getDeclaredField("byteValue"));
            System.out.printf("%d , %d , %d , %d",valueOffset,nameOffset,longValueOffset,byteValueOffset);
            unsafe.putObject(unsafeTestObj,nameOffset,"hhhh");
            System.out.println(unsafeTestObj.getName());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 内存操作
     */
    @Test
    public void test3(){
        final Unsafe unsafe = getUnsafe();

    }

    /**
     * 内存屏障
     */
    @Test
    public void test4(){
        final Unsafe unsafe = getUnsafe();
        unsafe.loadFence();
        unsafe.storeFence();

        //
        final Object lock = new Object();


        // comapare ---

        unsafe.monitorEnter(lock);

        // Opera--

        unsafe.monitorExit(lock);

        synchronized (lock){
            // opera..
        }

    }

    /**
     * CAS测试：重要！！！ 并发基石
     */
    @Test
    public void test5(){
        final Unsafe unsafe = getUnsafe();
        //unsafe.compareAndSwapLong()
        // obj,offset,expect,update

        // 期望是false,更新为true
        // 偏移量需要指定到具体的地址：底层硬件才知道 锁定那块内存位置？
        new AtomicBoolean().compareAndSet(false,true);
        //         return unsafe.compareAndSwapInt(this, valueOffset, e, u);

        // unsafe.getAndAddInt();
        //         do {
        //            var5 = this.getIntVolatile(var1, var2);
        //        } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));
    }

    /**
     *  <a href="https://ifeve.com/juc1/#more-40892">...</a>
     *
     * LongAdder的应用
     * AtomicLong类为开发人员使用线程安全的计数器提供了方便，但是AtomicLong在高并发下存在一些问题，
     * 当大量线程调用同一个AtomicLong的实例的方法时候，
     * 同时只有一个线程会CAS计数器的值成功，失败的线程则会原地占用cpu进行自旋转重试，这回造成大量线程白白浪费cpu原地自旋转。
     *
     * CAS 适合冲突较少（简单理解为写较少的场景）
     *
     * LongAdder内部维护多个Cell变量，在同等并发量的情况下，争夺单个变量更新操作的线程量会减少，这是变相的减少了争夺共享资源的并发量。
     *
     * 把并发量分担到多个原子变量上，让多个线程并发的对不同的原子变量进行操作，然后获取计数时候在把所有原子变量的计数和累加。
     *
     * 在5000 并发量左右  ： longAddr才体现出来优势
     */
    @Test
    public void test6() throws InterruptedException {
        LongAdder adder = new LongAdder();
        adder.increment();
        adder.sum();

        CountDownLatch countDownLatch = new CountDownLatch(5000*1000);
        long cur=System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                for (int j = 0; j < 5000; j++) {
                    adder.increment();
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        long now=System.currentTimeMillis();
        System.out.println((now-cur) +":" +adder.sum());//

        AtomicLong atomicLong = new AtomicLong(0);
        CountDownLatch countDownLatch2 = new CountDownLatch(5000*1000);
        cur=System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                for (int j = 0; j < 5000; j++) {
                    atomicLong.getAndIncrement();
                    countDownLatch2.countDown();
                }
            }).start();
        }
        countDownLatch2.await();
        now=System.currentTimeMillis();
        System.out.println((now-cur) +":" +atomicLong.get());

//        try {
//            Thread.currentThread().join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }


    public static void main(String[] args) {
        HelloUnsafe helloUnsafe = new HelloUnsafe();
        helloUnsafe.setName("ok");
    }

    @Data
    private static class UnsafeTestClazz{
        private Integer value;
        private String name;
        private Long longValue;
        private Byte byteValue;

    }




}
