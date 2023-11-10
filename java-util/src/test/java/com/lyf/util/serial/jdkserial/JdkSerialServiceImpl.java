package com.lyf.util.serial.jdkserial;

import com.google.common.collect.Maps;
import com.lyf.util.serial.SerialService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 * @author liyunfei
 **/
public class JdkSerialServiceImpl<T> implements SerialService<T> {

    private static final Map<Class<?>,String/*file path*/> map = Maps.newHashMap();

    private static final String DEFAULT_PATH = "";
    static {
        for (JdkSerialEnum value : JdkSerialEnum.values()) {
            map.put(value.getClazz(),value.getStoragePath());
        }
    }
    @Override
    public byte[] serial(T object) {
        try {
            // check是否在枚举类中
            FileOutputStream fileOutputStream = new FileOutputStream(map.getOrDefault(object.getClass(),DEFAULT_PATH));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            byte[]bytes = new byte[1024];
            objectOutputStream.write(bytes);
            return bytes;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //return new byte[0];
    }


    @Override
    public T deSerial(byte[] bytes) {

        return null;
    }
}
