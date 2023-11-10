package com.lyf.util.serial.jdkserial;

import com.lyf.util.serial.SerialService;

import java.io.Serializable;

/**
 * @author liyunfei
 **/
public class JdkSerialTests {

    public static void main(String[] args) {
        SerialService<Person> serialService = new JdkSerialServiceImpl<Person>();
        Person person = new Person();
        person.setId(1L);
        person.setAge(2);
        //未实现serila接口：RuntimeException: java.io.NotSerializableException: com.lyf.util.serial.jdkserial.Person

        //对比有无实现serial接口
        //对比修改版本号的，添加属性的问题
        //对比思考Io的二进制和文本，采用 binary Viewer去看

        serialService.serial(person);
    }
}
