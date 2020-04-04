package LINTCODE17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE1637 {
    /*Description
    * 给定一棵n个结点的树，第i个结点的父亲为fa[i-1]，价值为val[i-1]。
    * 特别地，1表示根节点, 2 表示第二个节点，以此类推，并且保证根节点的父亲是 -1 即 fa[0] = -1。
    * 某子树的平均价值为，该子树所有的结点val和除以该子树的结点数。
    * 求该树的子树最大平均价值的为多少, 返回这颗子树的根节点编号。
    * */

    double value=Double.MIN_VALUE;
    int result=-1;

    public int treeProblem(int[] fa, int[] val) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        map.put(0,new ArrayList<>());
        for(int i=1;i<fa.length;i++){
            int father=fa[i]-1;
            List<Integer> fatherList=map.getOrDefault(father,new ArrayList<>());
            fatherList.add(i);
            map.put(father,fatherList);
        }
        System.out.println(map);
        recursion(map,val,0);
        return result+1;
        // Write your code here
    }

    private int[] recursion(Map<Integer,List<Integer>> map, int[] val,int index){
        if(!map.containsKey(index)){
            if(val[index]>value||val[index]==value&&index<result) {
                result = index;
                value=val[index];
            }
            return new int[]{val[index],1};
        }
        List<Integer> list=map.get(index);
        int v=val[index];
        int time=1;
        for(int number:list){
            int[] cur=recursion(map,val,number);
            v+=cur[0];
            time+=cur[1];
        }
        double average=v*1.0/time;
        System.out.println(average+" "+index+" "+v+" "+time);
        if(average>value||average==value&&index<result) {
            result = index;
            value=average;
        }
        return new int[]{v,time};
    }
}
