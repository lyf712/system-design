package org.example;

import java.util.*;


public class Solution {
    public static void main(String[] args) {
        //[1,2,4,5,3],[4,2,5,1,3]
        int[]xianxu = {1,2,4,5,3};
        int[]zhognxu = {4,2,5,1,3};
        new Solution().solve(xianxu,zhognxu);
    }
    class Node{
        private int val;private Node left,right;
        public Node(){}
        public Node(int val){this.val = val;}
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     * @param xianxu int整型一维数组 先序遍历
     * @param zhongxu int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve (int[] xianxu, int[] zhongxu) {
        // write code here
        List<Integer> rs = new ArrayList<>();
        ///
        for(int i=0;i<zhongxu.length;i++){
            hash.put(zhongxu[i],i);
        }
        Node root = buildTree(xianxu,zhongxu,0,xianxu.length-1);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            //Node node = queue.poll();
            for(int i=0;i<size;i++){
                Node node = queue.poll();
                //if(i==size-1){
                rs.add(node.val);
                //}
                if(node.left!=null){queue.offer(node.left);}
                if(node.right!=null){queue.offer(node.right);}
            }
        }
        int[]rs0 = new int[rs.size()];
        for(int i=0;i<rs.size();i++){
            rs0[i] = rs.get(i);
        }
        return rs0;
    }
    HashMap<Integer,Integer> hash = new HashMap<>();
    int index=0;
    Node buildTree(int[] xianxu, int[] zhongxu,int left,int right){
        if(left>right){return null;}
        if(left==right){
            //index++;
            return new Node(xianxu[index++]);
        }
        Node root=new Node(xianxu[index++]);
        int mid = index-1;// 局部变量和共享变量@@
        root.left = buildTree(xianxu,zhongxu,left,hash.get(xianxu[index-1])-1);
        root.right = buildTree(xianxu,zhongxu,hash.get(xianxu[index-1])+1,right);
        return root;
    }
}