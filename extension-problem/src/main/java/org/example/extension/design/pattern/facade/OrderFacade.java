package org.example.extension.design.pattern.facade;

import java.util.List;

/**
 * @author liyunfei
 **/
public interface OrderFacade {

    /**
     * 订单统计服务.
     * @return
     */
    Object staticsServiceMethod();

    List<Object> query();


}
