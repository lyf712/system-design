package com.lyf.util.basic;

import com.google.common.math.DoubleMath;
import com.google.common.math.IntMath;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 应用场景：
 * 1.gmv统计等常见
 * 2.比例占比--
 *
 *
 * @author liyunfei
 **/
public class MathTests {

    @Test
    public void test1(){
        IntMath.divide(3,2, RoundingMode.FLOOR);
        DoubleMath.factorial(2);
        Double d = 2.2;
        BigDecimal bigDecimal = new BigDecimal(2.2111231);
        bigDecimal.setScale(4,RoundingMode.CEILING);

        System.out.println(bigDecimal.doubleValue());
    }


    /**
     * 保留小数问题
     */
    @Test
    public void test2(){
         double val = 10.21231343;
        System.out.println(String.format("%.2f",val));
        System.out.println(new DecimalFormat("#.00").format(val));
       // System.out.println();


    }

}
