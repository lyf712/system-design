package com.lyf.util.serial.jsonserial;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @author liyunfei
 **/
public class FastjsonTests {

    /**
     * JSON obejct,array
     */
    @Test
    public void test1(){
        Order order = new Order();
        order.setOrderId(1L);
        order.setOrderDesc("test-order");
        String jsonString = JSONObject.toJSONString(order);
        System.out.println(jsonString);

        order = JSONObject.parseObject(jsonString, Order.class);
        System.out.println(order.getOrderDesc());
    }
}
