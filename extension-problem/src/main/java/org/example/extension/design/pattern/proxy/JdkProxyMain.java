package org.example.extension.design.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author liyunfei
 **/
public class JdkProxyMain {
    private interface ITargetService{
        void sayHello();
    }
    private static class TestTargetService implements ITargetService{
        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }
    private static class ProxyTarget implements InvocationHandler{
        private final Object o;

        public ProxyTarget(Object o) {
            this.o = o;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("pre");
            method.invoke(o,args);

            System.out.println("post");

            //
            System.out.println("测试代理");
            System.out.println(Arrays.toString(proxy.getClass().getMethods()));
            //method.invoke(proxy,args);
            return null;
        }
    }

    public static void main(String[] args) {

        TestTargetService testTargetService = new TestTargetService();
        Object o
        = Proxy.newProxyInstance(testTargetService.getClass().getClassLoader(), testTargetService.getClass().getInterfaces(), new ProxyTarget(testTargetService));
        ((ITargetService) o).sayHello();

    }
}
