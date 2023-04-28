package org.example;

import java.util.*;

/**
 * @author liyunfei
 **/
public class HashMapTest {
    public static void main(String[] args) {
        HashMap map = new HashMap();
    }

        public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
            // 双指针方法,如何解决去重的问题？
            ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
            HashSet<ArrayList<Integer>> hash = new HashSet<>();
            Arrays.sort(num);
            for(int i = num.length-1;i>=2;i--){
                int target = (-1) * num[i];
                int left = 0, right = i-1;
                while(left<right){
                    if(num[left]+num[right]==target){
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[left]);
                        tmp.add(num[right]);
                        tmp.add(num[i]);
                        if(!hash.contains(tmp))
                            rs.add(tmp);
                        hash.add(tmp);
                        left++;
                        right--;
                    }else if(num[left]+num[right]<target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
            Collections.sort(rs, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    return 0;
                }
            });
//            Arrays.sort(rs,(e1,e2)->{
//                for(int i=0;i<=2;i++){
//                    if(e1.get(i)<e2.get(i)){
//                        return 1;
//                    }else if(e1.get(i)>e2.get(i)){
//                        return -1;
//                    }
//                }
//                return 0;
//            });
            return rs;
        }

}
