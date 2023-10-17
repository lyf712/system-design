package org.example.extension.design.pattern;

import org.example.extension.design.pattern.enums.PayStrategyEnum;

import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liyunfei
 **/
public class PayStrategyFactory {

    private List<PayStrategy> payStrategy;

    private final static Map<String/*路由key-type*/,PayStrategy> payStrategyMap = new ConcurrentHashMap<>(16);

    static {
        // ServiceLoader
        for (PayStrategyEnum value : PayStrategyEnum.values()) {
            //payStrategyMap.put()
        }
    }

}
