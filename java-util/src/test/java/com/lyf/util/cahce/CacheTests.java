package com.lyf.util.cahce;

import com.google.common.cache.*;
import com.google.common.util.concurrent.ListenableFuture;
import com.lyf.util.serial.jdkserial.Person;
import org.junit.Test;

import java.sql.Time;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 **/
public class CacheTests {

    /**
     * 适用场景：1.内存换时间 2.反复被读 ，解决读的压力 3.
     *
     * 几个关键点：
     * 1. 过期时间、key的选取
     * 2. 更新时机、淘汰策略，容量大小
     *
     */
    @Test
    public void test1() throws ExecutionException {



        LoadingCache<String/*access_code*/, Boolean>
             permissionCache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                     .expireAfterAccess(5, TimeUnit.SECONDS)

                .weigher(new Weigher<String, Boolean>() {
                    @Override
                    public int weigh(String key, Boolean value) {
                        return key.length();
                    }
                })
                .removalListener(new RemovalListener<String, Boolean>() {
                    @Override
                    public void onRemoval(RemovalNotification<String, Boolean> notification) {
                        // 一般用于连接类--
                        System.out.println("close---handle");
                    }
                })
                     .build(new CacheLoader<String, Boolean>() {
                         @Override
                         public Boolean load(String key) throws Exception {
                             return query(key);
                         }

                         //A CacheLoader may specify smart behavior to use on a refresh by overriding CacheLoader.reload(K, V),
                         // which allows you to use the old value in computing the new value.
                         @Override
                         public ListenableFuture<Boolean> reload(String key, Boolean oldValue) throws Exception {
                             //     permissionCache.refresh("lyf_code");
                             return super.reload(key, oldValue);
                         }

                         // 全量逻辑--加载所有
                         @Override
                         public Map<String, Boolean> loadAll(Iterable<? extends String> keys) throws Exception {
                             return super.loadAll(keys);
                         }
                     });

        permissionCache.get("lyf_code");
        permissionCache.get("lyf_code");


        try {
            TimeUnit.SECONDS.sleep(6);
            permissionCache.get("lyf_code");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
    // mock -- rcp\db service----
    private boolean query(String key){
        System.out.println("execute --- query");
        return new Random().nextInt(2)==1;
    }
}
