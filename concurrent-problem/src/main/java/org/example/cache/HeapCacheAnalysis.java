package org.example.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.core.EhcacheManager;
import org.ehcache.core.config.DefaultConfiguration;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 堆内缓存分析：
 * ehcache、guava、mapDB
 * @author liyunfei
 **/
public class HeapCacheAnalysis {

     private Unsafe U = Unsafe.getUnsafe();

     static class InternalCache extends LinkedHashMap {

     }

     @Test
     public void testMap(){
          // 本身的ConcurrentHashMap数据结构则是采用堆的内存
          // static 则是 方法区
          Map<String,String> map = new LinkedHashMap<>();
          // 直接内存
          // U.allocateMemory()
          // SoftReference
          // WeakReference<Object> weakReference = new WeakReference<>(1);
     }


     /**
      * 尝试guava的堆内缓存设计
      */
     @Test
     public void testGuavaCacheByHeap(){
          /**
           * 堆内缓存
           * 采用builder的设计模式构造Cache
           * LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>
           */
          Cache<String,String> cache = CacheBuilder
                                      .newBuilder()
                                      .maximumSize(10000)
                   // 修改分段锁的并行度，性能对比1.8的ConcurrentMap?
                  .concurrencyLevel(4)
                   // TTL的策略淘汰
                  .expireAfterWrite(1000, TimeUnit.SECONDS)
                  .build();
          //      volatile AtomicReferenceArray<ReferenceEntry<K, V>> table;
          //cache.put();
          cache.put("person:1","{name:lyf,age:12}");
     }

     /**
      * 测试Ehcache的堆内缓存
      */
     @Test
     public void testEhcacheByHeap(){
          //CacheManager cacheManager = //new EhcacheManager()
          // CacheManagerBuilder.newCacheManagerBuilder().build();

     }

     @Test
     public void testMapDB(){

     }
}
