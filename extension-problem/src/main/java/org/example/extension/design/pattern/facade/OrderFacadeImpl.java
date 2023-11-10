package org.example.extension.design.pattern.facade;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

/**
 * @author liyunfei
 **/
public class OrderFacadeImpl implements OrderFacade {

    /**
     * 相关应用：
     * Spring的ResourceLoader
     * 生活场景：组装电脑--
     * netty的Channel
     */


    // 一般RPC--去--

    private StaticsService staticsService;

    private OrderCommonService orderCommonService;

    @Override
    public Object staticsServiceMethod() {
        // 组织内部的服务--
        return null;
    }

    @Override
    public List<Object> query() {
        return null;
    }
}
