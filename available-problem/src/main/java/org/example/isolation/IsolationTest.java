package org.example.isolation;

import com.netflix.hystrix.HystrixThreadPool;
import org.apache.catalina.startup.Tomcat;
import org.junit.Test;

import java.util.Timer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 隔离的粒度：
 * 线程【重点关注，一般通过线程池隔离】》进程》机器》机房
 *
 * @author liyunfei
 **/
public class IsolationTest {

    class DemoFactory implements ThreadFactory{
        private String factoryName;
        private AtomicInteger threadId = new AtomicInteger(0);

        public DemoFactory(String factoryName) {
            this.factoryName = factoryName;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r,factoryName
                    .concat("-")
                    .concat(String.valueOf(threadId.incrementAndGet())));
            t.start();
            return t;
        }
    }

    private final String coreTaskFactoryName = "coreTask";

    private final String asyncTaskFactoryName = "asyncTask";

    private final ThreadPoolExecutor corePool = new ThreadPoolExecutor(5,9,60,
            TimeUnit.SECONDS,new ArrayBlockingQueue<>(10),new DemoFactory(coreTaskFactoryName));

    private final ThreadPoolExecutor asyncPool = new ThreadPoolExecutor(2,5,60,
            TimeUnit.SECONDS,new ArrayBlockingQueue<>(5),new DemoFactory(asyncTaskFactoryName));

    class Task implements Runnable{
        // 模拟异常发生时间延时
        private long exceptionT;

        public Task(long exceptionT) {
            this.exceptionT = exceptionT;
        }

        @Override
        public void run() {
               long count = 0;
               while (count<exceptionT){
                   System.out.println(Thread.currentThread().getName()+" execute at "+System.currentTimeMillis());
//                   try {
//                       TimeUnit.SECONDS.sleep(1);
//                   } catch (InterruptedException e) {
//                       throw new RuntimeException(e);
//                   }
                   count++;
               }
               System.out.println("end");
        }
    }

    /**
     * 测试不同线程和相同线程池的线程运行影响
     */
    @Test
    public void testThreadPoolIsolation() throws InterruptedException {
           corePool.submit(new Task(4));

           TimeUnit.SECONDS.sleep(1000);
    }

    /**
     * 1.理解基本的原理（采用信号量和线程池去隔离）
     * 2.查看层次结构和设计基本原理(command，命令设计模式）
     *
     */
    @Test
    public void testHystrix(){
        // HystrixThreadPool
    }

    /**
     * 1.分析Tomcat的解析过程，采用不同线程对业务和解析进行隔离
     */
    @Test
    public void testServlet3(){
        // Tomcat
    }
}
