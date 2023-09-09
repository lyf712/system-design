package org.example.cache.consistency;

/**
 * 缓存DB一致性策略问题（要将读写策略分离，分开思考）：
 * 1.先更新缓存，在更新DB
 * 2.先更新DB，在更新缓存
 * 3.旁路缓存策略：对于写策略（删除缓存，写数据库），读策略（读到为空，则拉取DB）
 * 4.延迟双删策略
 * @author liyunfei
 **/
public interface CacheDbConsistencyStrategy {

}
