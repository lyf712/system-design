package com.lyf.util.collections;

import com.google.common.collect.*;
import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @author liyunfei
 **/
public class CollectionsTests {
    /**
     * 1.对比JDK的集合，Guava进行了哪些提升，拓展（基于什么样的点，
     * <li>
     *     基于代码风格 例如 new ArrayList<Type>(),这样精简声明冗余
     * </li>
     * <li>
     *    设计的思考：create(),newL..(),静态工厂方法的使用设计
     * </li>
     *
     *
     */
    @Data
    private static class DisplayVO{

        private String orderName;

        private String mallName;

        private String goodsName;

        private String buyerName;

    }

    @Data
    private static class MallDTO{

    }

    @Data
    private static class GoodsDTO{

    }

    // 常见的基础操作
    @Test
    public void test1(){

        // list 有序列表
        // 订单列表、分页查询的列表，商品列表等，
        // 基本操作：基于某种维度进行排序，并映射为大的VO
        List<Integer> list = Lists.newArrayList(1,1,2,4);
        // 声明使用
        Lists.newArrayListWithCapacity(10);
        Lists.newLinkedList();

        Lists.partition(list,2);

        List<DisplayVO> displayVOS = list.stream()
                .filter(Objects::nonNull)
                .map(orderId -> {
                    DisplayVO displayVO = new DisplayVO();

                    // rpc调用---三方业务组装数据 OR 查数据库 -- ，调用频繁----一般会该用批量查询


                    return displayVO;
                }).collect(Collectors.toList());
        Map<Integer,MallDTO> mallDTOMap = Maps.newHashMap();
        Map<Integer,GoodsDTO> goodsDTOMap = Maps.newHashMap();


        CompletableFuture<Boolean> mallFuture = CompletableFuture.supplyAsync(()->{
            // mallRpcService.batchQuery(List<>);
            // -- 存mallDTOMap
            return true;
        });

        //     e.execute(new AsyncSupply<U>(d, f));
        CompletableFuture<Boolean> goodsFuture = CompletableFuture.supplyAsync(()->{
            // goodsRpcService.batchQuery(List<>);
            // -- 存mallDTOMap
            return true;
        });


        // 中间一些其他处理，例如发通知，事件机制等---


        try {
            mallFuture.get();
            goodsFuture.get();

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        // Set:交，并，补
        // diff逻辑，若有新增敏感词、商品则进行通知报告
        List<Integer> oldList = Lists.newArrayList(1,2,3,4);
        List<Integer> newList = Lists.newArrayList(2,3,5);
        Set<Integer> rs = new HashSet<>();

        // 1,4
        //Sets.difference(new HashSet<>(oldList),new HashSet<>(newList)).copyInto(rs);
        // var1,相对 var2的diff逻辑
        // 5
        Sets.difference(new HashSet<>(newList),new HashSet<>(oldList)).copyInto(rs);
        rs.forEach(System.out::println);
//        System.out.println("->>>>>>>>>>>>");
//        // 2,3
//        Sets.intersection(new HashSet<>(oldList),new HashSet<>(newList)).copyInto(rs);
//        rs.forEach(System.out::println);
//        System.out.println("->>>>>>>>>>>>");
        // noto: copyInfo会累加 ，例如 第一次diff没有注释掉，做interaction时会出现1,2,3,4的情况
        // 1,2,3,4,5
//        Sets.union(new HashSet<>(oldList),new HashSet<>(newList)).copyInto(rs);
//        rs.forEach(System.out::println);

//        Sets.difference();
//        Sets.union();
//        Sets.intersection();
        //   System.arraycopy(original, 0, copy, 0,
        //                         Math.min(original.length, newLength));
//        List<Integer> rsList = new ArrayList<>(rs);
//        rsList.forEach(System.out::println);

        Map<String,String> map1 = Maps.newHashMap();
        Map<String,String> map2 = Maps.newHashMap();
        map1.put("1","p");
        map1.put("2","l");
        map1.put("3","k");

        map2.put("2","f");
        map2.put("4","g");

// 空
        Maps.difference(map1,map2).entriesInCommon().forEach((k,v)->{
            System.out.printf("%s,%s",k,v);
        });
//4,g
//        Maps.difference(map1,map2).entriesOnlyOnRight().forEach((k,v)->{
//            System.out.printf("%s,%s \n",k,v);
//        });

//1,p
//3,k
//        Maps.difference(map1,map2).entriesOnlyOnLeft().forEach((k,v)->{
//            System.out.printf("%s,%s \n",k,v);
//        });


        // Collections工具类
        //Collections.sort(list);

        Collections.max(list);
        Collections.min(rs);
        Collections.sort(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        //Collections.frequency(list,1);

        // 排列组合？？
        // Collections2.permutations()

    }

    @Test
    public void test2(){
        // multi的理解？？
        Multimaps.newMultimap(Maps.newHashMap(),()->{
            return Lists.newArrayList();
        });

        BitSet set = new BitSet();


    }
}
