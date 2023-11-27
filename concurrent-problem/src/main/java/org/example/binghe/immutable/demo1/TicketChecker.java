package org.example.binghe.immutable.demo1;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Hang YU
 **/
public class TicketChecker {
    private Map<String,User> userMap=new ConcurrentHashMap<>();

    public void update(String key,User user){
        userMap.put(key,user);
    }

    public void print(){

    }

    public Map<String,User> getUserMap(){
        // 不可变，只可读
        return Collections.unmodifiableMap(userMap);
    }
}
