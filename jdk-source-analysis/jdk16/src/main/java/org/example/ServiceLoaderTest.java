package org.example;

import java.util.ServiceLoader;

/**
 * @author liyunfei
 **/
public class ServiceLoaderTest {
    public static void main(String[] args) {
        ServiceLoader serviceLoader = ServiceLoader.load(ServiceLoaderTest.class);
    }
}
