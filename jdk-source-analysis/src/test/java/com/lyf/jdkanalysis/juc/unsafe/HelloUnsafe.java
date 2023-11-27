package com.lyf.jdkanalysis.juc.unsafe;

import lombok.Data;
import sun.misc.Unsafe;

/**
 * @author liyunfei
 **/
@Data
public class HelloUnsafe {
    private static final Unsafe U = Unsafe.getUnsafe();

    private static long nameOffset;
    private static long idOffset;
    private static long ageOffset;


    private String name;
    private Long id;
    private Integer age;



    static {
        try {
            nameOffset = U.objectFieldOffset(HelloUnsafe.class.getDeclaredField("name"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }
}
