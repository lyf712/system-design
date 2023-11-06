package com.lyf.util.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liyunfei
 **/
@Data
public class Goods implements Serializable {

    private Long goodsId;

    private String goodsName;

    private String mallId;

    private Long price;

}
