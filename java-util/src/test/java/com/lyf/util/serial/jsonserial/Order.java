package com.lyf.util.serial.jsonserial;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liyunfei
 **/
@Data
public class Order implements Serializable {

    //用于属性，把属性的名称序列化时转换为另外一个名称
    @JsonProperty("order_id")
    private Long orderId;

    @JsonProperty("order_desc")
    private String orderDesc;

    //用于属性或者方法，把属性的格式序列化时转换成指定的格式
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm")
    private Date date = new Date();

}
