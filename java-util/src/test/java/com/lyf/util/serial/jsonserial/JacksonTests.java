package com.lyf.util.serial.jsonserial;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author liyunfei
 **/
public class JacksonTests {

    /**
     * <a href="https://www.jb51.net/article/203859.htm">jackson的基本使用</a>
     * 1.应用与SpringMVC中，速度适中且安全。。 fastjson快但安全漏洞问题
     *
     */
    @Test
    public void test1(){
        ObjectMapper objectMapper = new ObjectMapper();
        // 配置基础信息,例如但json有，对象无时--
        //objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,true);
        Order order = new Order();
        order.setOrderId(1L);
        order.setOrderDesc("test-order");
        try {
            String str = objectMapper.writeValueAsString(order);
            System.out.println(str);
            Order value = objectMapper.readValue(str, Order.class);
            System.out.println(value.getOrderDesc());

            //
            //byte[],URL,FIle,---stream
            objectMapper.writeValue(new File(""),order);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
