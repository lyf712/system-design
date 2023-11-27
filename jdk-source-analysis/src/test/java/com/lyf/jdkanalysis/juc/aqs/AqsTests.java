package com.lyf.jdkanalysis.juc.aqs;

import org.junit.Test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author liyunfei
 **/
public class AqsTests {


    // 模板方法设计：父类不实现，交由子类实现

    static class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(1,0);
                    //super.tryAcquire(arg);
        }

        @Override
        protected boolean tryRelease(int arg) {
            return compareAndSetState(0,1);
                    //super.tryRelease(arg);
        }
    }

    final Sync sync = new Sync();

    @Test
    public void test(){
        sync.acquire(1);
    }


}
