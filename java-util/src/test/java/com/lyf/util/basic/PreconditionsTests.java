package com.lyf.util.basic;

import com.google.common.base.Preconditions;
import org.junit.Test;

/**
 * @author liyunfei
 **/
public class PreconditionsTests {
    @Test
    public void test1(){
        // 一般来说用不着，，，业务会自己封装  BussinessException---

        Preconditions.checkArgument(1<0,"Argument error");
    }
}
