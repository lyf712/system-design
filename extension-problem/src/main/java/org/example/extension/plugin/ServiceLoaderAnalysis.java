package org.example.extension.plugin;

import org.junit.jupiter.api.Test;

import java.util.ServiceLoader;

/**
 * @author liyunfei
 **/
public class ServiceLoaderAnalysis {

      // 做插件进行灵活拓展，自需自定义协议标准（并规定实现的默认路径，serviceLoader是默认的META-INFO/services
      // ,Dubbo为了更灵活地实现这些插件，直接利用ClassLoader，未采用ServiceLoader，并可自定义了更多的路径和拓展可能性
      // ），具体的实现交由具体厂商去实现。

      // 常见的应用： Dubbo的SPI机制、Spring的spring.factoies,  JDBC的Driver，Nacos的做插件生态（原生的ServiceLoader封装
      // 一些有趣的插件设计：IDEA的插件设计（），注解Lombox框架前端识别--

      @Test
      public void testServiceLoaderBase(){
            // LazyIterator.Private inner class implementing fully-lazy provider lookup
            //   String fullName = PREFIX + service.getName();
            //                    if (loader == null)
            //                        configs = ClassLoader.getSystemResources(fullName);
            //                    else
            //                        configs = loader.getResources(fullName);
            // jdk1.6时，，主要利用的是ClassLoader机制，动态加载二进制~ 也正因为Java这个动态加载机制
            // 很多中间件在此做文章，玩花样~
            // jdk1.9模块化后的加载路径封装~对比
            ServiceLoader<IStandard> iStandardServiceLoader = ServiceLoader.load(IStandard.class);

            // 对于

      }
}
