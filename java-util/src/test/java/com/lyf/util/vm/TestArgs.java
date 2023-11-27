package com.lyf.util.vm;

/**
 * @author liyunfei
 **/
public class TestArgs {
    public static void main(String[] args) {
        //ProcessBuilder processBuilder = ProcessTools.create
        //
        try {
            ClassLoader.getSystemClassLoader().loadClass("");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
