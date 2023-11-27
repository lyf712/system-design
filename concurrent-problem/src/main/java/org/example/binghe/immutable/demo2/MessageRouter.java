package org.example.binghe.immutable.demo2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liyunfei
 **/
public class MessageRouter {
    private final Map<String,MessageInfo> messageInfoMap = new ConcurrentHashMap<>();
}
