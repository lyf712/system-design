package org.example.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.util.concurrent.ListenableFuture;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author liyunfei
 **/
public class GuavaBaseUseTests {
   @Test
   public void test(){
       Cache<Object,Object> cache = CacheBuilder.newBuilder()
               .expireAfterAccess(10, TimeUnit.MINUTES)
               .maximumSize(100)
               .build(new CacheLoader<Object, Object>() {
                   @Override
                   public Object load(Object o) throws Exception {
                       return getKeyFromDB(o);
                   }

                   @Override
                   public ListenableFuture<Object> reload(Object key, Object oldValue) throws Exception {
                       return super.reload(key, oldValue);
                   }
               });
       //cache.get()
   }
    Object getKeyFromDB(Object o){
       return"";
    }
}
