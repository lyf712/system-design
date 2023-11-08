package com.lyf.util.basic;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liyunfei
 **/
public class PrimitiveTests {
    /**
     * 对象包装类
     */

    @Test
    public void test1(){
        //一般进行单元测试，造数据，会采用---
        //IntArrayAsList extends AbstractList<Integer>
        List<Integer> integerList = Ints.asList(1, 2, 3);
        //JDK自身的ArrayList
        ArrayList<Integer> integerArrayList = Lists.newArrayList(1, 2, 3);

        // toByte的应用场景？new byte[]{(byte)(value >> 24), (byte)(value >> 16), (byte)(value >> 8), (byte)value}
        /**
         * 网络通信：在网络通信中，数据通常以字节数组的形式传输。将Integer转换为字节数组后，可以轻松地将整数数据发送到另一台计算机或接收来自其他计算机的整数数据。
         * 数据存储：有时需要将整数数据存储在文件或数据库中。将整数转换为字节数组后，可以将其写入文件或存储在数据库表中，并在需要时重新加载并还原为整数。
         * 自定义协议：在自定义通信协议中，可能需要将整数编码为特定的字节数组格式以进行数据传输。Guava的Ints.toByteArray(int)方法可用于执行此操作。
         * 数据序列化：在某些情况下，将整数数据序列化为字节数组是必要的，例如在使用消息队列或缓存系统时，可以使用字节数组来传输和存储数据。
         */
        Ints.toByteArray(2);
        Ints.join(",",1,2,3);
//        Integer[]arr = {1,3,3};
//        Ints.join(",",arr);


        //Integer.bitCount()
        //Arrays.sort();

        Ints.concat(new int[]{13,4,1,},new int[]{12,3,3,1});

        try {
            //todo 结合jackson一起总结 -- 序列化问题
//            ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(Ints.toByteArray(2)));
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new ByteArrayOutputStream(2));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new ByteArrayOutputStream());
            objectOutputStream.writeObject(Ints.toByteArray(2));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
