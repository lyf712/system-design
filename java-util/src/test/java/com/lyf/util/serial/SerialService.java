package com.lyf.util.serial;

/**
 * @author liyunfei
 **/
public interface SerialService<T> {

    byte[] serial(T object);

    T deSerial(byte[] bytes);

}
