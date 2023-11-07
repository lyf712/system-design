package com.lyf.util.basic;

import com.google.common.base.*;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * @author liyunfei
 **/
public class StringsTests {

    /**
     * 关于拼接：
     * StringBuffer的append
     * 直接 String 的 + 本质是append
     * String.format("",)
     *
     */
    @Test
    public void testJoin(){

        // 避免重复的采用 , 去---分割，若手动写则很---
        Joiner joiner = Joiner.on(",").skipNulls();
        String rs = joiner.join(Arrays.asList(1,2,3));
        System.out.println(rs);

        rs = "1" + "," +","+null+":";
        System.out.println(rs);

        joiner = Joiner.on(",").useForNull("null");
        rs = joiner.join(Arrays.asList(1,2,null,3));
        System.out.println(rs);
    }

    @Test
    public void testSplit(){
        String str = "1,2,3,4,5";
        // 采用的正则实现，效率比较低---todo
        String[] strs = str.split(",");
        System.out.println(Arrays.toString(strs));

        str = "1,2,3,4, 5";
        // 采用的正则实现，效率比较低---todo
        strs = str.split(",");
        System.out.println(Arrays.toString(strs));

        //List<Integer> list = Arrays.stream(strs).map(Integer::valueOf).collect(Collectors.toList());

        List<Integer> list = Splitter
                // 匹配分割
                .on(",")
                // 修改--整理
                .omitEmptyStrings()
                .trimResults(CharMatcher.is(' '))
                .splitToStream(str).map(Integer::valueOf).collect(Collectors.toList());

        // 应用场景较多，，，例如存储站点  [1,20,102,11] 正反解析


    }

    @Test
    public void testLang(){
        // commonlang
        StringUtils.equals("","");
        StringUtils.isNotBlank("");
        StringUtils.isNotEmpty("");
    }

    @Test
    public void testStrings(){
        //Strings.commonPrefix()
    }

    @Test
    public void testStringToken(){
        // todo---
        StringTokenizer stringTokenizer = new StringTokenizer("");

        //stringTokenizer.hasMoreTokens()
    }
}
