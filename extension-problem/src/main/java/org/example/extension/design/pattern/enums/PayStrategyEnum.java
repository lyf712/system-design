package org.example.extension.design.pattern.enums;

import org.example.extension.design.pattern.straties.AliPayStrategy;

/**
 * @author liyunfei
 **/
public enum PayStrategyEnum {

    /**
     * type,desc,code,clz..
     */
    ALIPAY("阿里支付",1, AliPayStrategy.class);

    /**
     *
     */
    private final String desc;
    /**
     *
     */
    private final Integer code;
    /**
     *
     */
    private final Class<?> clz;


    PayStrategyEnum(String desc, Integer code, Class<?> clz) {
        this.desc = desc;
        this.code = code;
        this.clz = clz;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getCode() {
        return code;
    }

    public Class<?> getClz() {
        return clz;
    }
}
