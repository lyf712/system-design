package com.lyf.util.basic;

import com.google.common.base.Strings;
import com.lyf.util.domain.Goods;
import com.sun.deploy.util.StringUtils;
import org.junit.Test;

import java.util.*;

/**
 * @author liyunfei
 **/
public class NullTests {

    /**
     * 常见的Null情况。
     * 为空的是数据（而数据分为 ，集合（尤其是Map.get）管理的数据，String，数组，单个数据，
     * 都需要去考虑判空
     */


    @Test
    public void test1(){
       List<Goods> goodsList = new ArrayList<>();
       Goods goods1 =  new Goods();
       goods1.setPrice(1L);
       goodsList.add(goods1);
       goodsList.add(null);
       // 1.stream流处理时，易忽略空
       Optional<Long> optionalPrice = goodsList.stream()
               //.filter(Objects::nonNull)
               .map(Goods::getPrice)
               .max(Comparator.naturalOrder());
       //optionalPrice.orElse()

        // 2.第三方请求的数据对象

        Strings.isNullOrEmpty("");


        // Optional的使用
        com.google.common.base.Optional<Integer> optional = com.google.common.base.Optional.of(1);
        optional.isPresent();

        //optional.or()
    }
}
