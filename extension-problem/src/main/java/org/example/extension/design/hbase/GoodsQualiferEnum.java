package org.example.extension.design.hbase;

/**
 * @author liyunfei
 **/
public enum GoodsQualiferEnum {
    /**
     *
     */
    BASE("gi:base", GoodsBaseDTO.class,String.class);

    private String qualifier;

    private Class<?> qualifierClazz;

    private Class<?> serialClazz;

    GoodsQualiferEnum(String qualifier, Class<?> qualifierClazz, Class<?> serialClazz) {
        this.qualifier = qualifier;
        this.qualifierClazz = qualifierClazz;
        this.serialClazz = serialClazz;
    }
}
