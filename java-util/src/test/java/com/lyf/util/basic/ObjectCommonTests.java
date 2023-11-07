package com.lyf.util.basic;

import com.google.common.base.MoreObjects;
import com.lyf.util.domain.Goods;
import org.junit.Test;

import java.util.Objects;

/**
 * @author liyunfei
 **/
public class ObjectCommonTests {

    @Test
    public void test1(){
        //  return (a == b) || (a != null && a.equals(b))
        Objects.equals("1",null);
        //  return a == b || a != null && a.equals(b);
        com.google.common.base.Objects.equal("1",null);

        // JDK1.7开始提供了该两种方法
        Objects.hash("");
        com.google.common.base.Objects.hashCode("");

        // 魔法值，，一些开源组件还能看到，不太提倡，更加 杜绝 object（未知是否为空）.equal()
        "".equals("");

        // ------
        //            StringBuilder builder = (new StringBuilder(32)).append(this.className).append('{');
        // --

        // 该设计有点意思，Build设计有点像（业务场景中去  拼凑 消息模板可以用
        String str = MoreObjects.toStringHelper(Goods.class)
                .add("goodsIds","1111")
                .toString();
        System.out.println(str);

        str = MoreObjects.toStringHelper("NoClass")
                .add("goodsIds","1111")
                .toString();
        System.out.println(str);

        //Goods{goodsIds=1111}
        //NoClass{goodsIds=1111}



    }

    @Test
    public void test2(){


    }


}
