package LINTCODE10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE953 {
    /*Description
    *一棵 n 个结点的多叉树，结点编号为[0, n - 1]，根结点的编号为 0。每个结点有一个收益，到这个结点了，
    * 就可以加上这个结点的收益；每条边有一个花费，沿着这条边走，就要减去这条边的花费。
    * 问，从根结点走到任意一个叶子结点的总得分（总得分 = 总收益 - 总花费）最大为多少？
    * */

    int result=Integer.MIN_VALUE;
    public int getMaxScore(int[] x, int[] y, int[] cost, int[] profit) {
        if(profit.length==0)
            return 0;
        if(profit.length==1)
            return profit[0];
        Map<Integer, List<int[]>> map=new HashMap<>();
        for(int i=0;i<x.length;i++){
            int father=x[i];
            List<int[]> list=map.getOrDefault(father,new ArrayList<>());
            list.add(new int[]{y[i],cost[i]});
            map.put(father,list);
        }
        recursion(map,0,0,profit);
        return result;
        // Write your code here
    }

    private void recursion(Map<Integer,List<int[]>> map,int index,int curSum,int[] profit){
        if(!map.containsKey(index)){
            result=Math.max(result,profit[index]+curSum);
            return;
        }
        List<int[]> list=map.get(index);
        for(int[] cur:list){
            recursion(map,cur[0],curSum+profit[index]-cur[1],profit);
        }
    }
}
