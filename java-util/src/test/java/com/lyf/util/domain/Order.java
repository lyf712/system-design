package com.lyf.util.domain;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

/**
 * @author liyunfei
 **/
public class Order implements Comparable<Order>{

    private enum TYPE{
        VIP,
        COMMON,
        OTHER
    }

    private TYPE type;

    private Long orderId;

    private String desc;

    @Override
    public int compareTo(Order o) {
        // =-- LESS,GREATER CHAIN todo
        return ComparisonChain.start()
                .compare(this.type,o.type, Ordering.natural().nullsLast())
                .compare(this.orderId,o.orderId).result();
    }
}
