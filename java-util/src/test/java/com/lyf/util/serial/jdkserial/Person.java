package com.lyf.util.serial.jdkserial;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liyunfei
 **/
@Data
public class Person implements Serializable {
    // 8byte
    private Long id;
    // 4byte
    private Integer age;


}
