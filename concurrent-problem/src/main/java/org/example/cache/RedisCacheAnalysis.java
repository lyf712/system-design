package org.example.cache;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisClient;
import org.redisson.client.RedisClientConfig;
import org.redisson.client.RedisConnection;
import org.redisson.client.protocol.CommandsData;
import org.redisson.config.Config;

/**
 *  分布式锁 @see <a href="https://blog.csdn.net/ohwang/article/details/125038268"></a>
 * @author liyunfei
 **/
public class RedisCacheAnalysis {
    @Test
    public void testRedisBase(){
        Config config = new Config();
        final String serverAddress = "redis://127.0.0.1:6379";
        config.useSingleServer().setAddress(serverAddress);
        // 思考为何构造器设置为子类访问域，交由静态方法区实习创建
        RedissonClient redisson= Redisson.create(config);

        RedisClientConfig redisClientConfig = new RedisClientConfig();
        redisClientConfig.setAddress(serverAddress);
        RedisClient redisClient = RedisClient.create(redisClientConfig);
        RedisConnection redisConnection = redisClient.connect();
        //redisConnection.send(new CommandsData());
        //redisClient.
        //redisConnection.getChannel().


    }
}
