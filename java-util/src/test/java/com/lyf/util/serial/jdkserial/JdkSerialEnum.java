package com.lyf.util.serial.jdkserial;

import com.lyf.util.serial.Constants;

/**
 * @author liyunfei
 **/
public enum JdkSerialEnum {


    PERSON(Person.class, Constants.JDK_PATH_PREFIX+"\\"+Person.class.getName()+".out");

    private final Class<?> clazz;

    private final String storagePath;

    //public static final String PREFIX = "E:\\JavaProjects\\LearnProjects\\system-design\\java-util\\src\\test\\java\\com\\lyf\\util\\serial\\jdkserial\\files";

    JdkSerialEnum(Class<?> clazz, String storagePath) {
        this.clazz = clazz;
        this.storagePath = storagePath;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public String getStoragePath() {
        return storagePath;
    }
}
