package LINTCODE15;

import java.util.*;

public class LINTCODE1403 {
    /*Description
    * 一棵有 n 个结点，根结点为 1 的二叉树，每条边通过两个顶点x[i],y[i]来描述，每个点的权值通过d[i]来描述。
    * 求从根结点到叶子结点路径上所有结点权值乘积对1e9+7取模后最大的路径的值。
    * */

    public int getProduct(int[] x, int[] y, int[] d) {
        int number=d.length;
        long[] value=new long[number];
        long mod=1000000007;
        for(int i=0;i<number;i++){
            value[i]=d[i];
        }
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<x.length;i++){
            List<Integer> list=map.getOrDefault(x[i],new ArrayList<>());
            list.add(y[i]);
            map.put(x[i],list);
        }
        Queue<Integer> queue=new LinkedList<>();
        queue.add(1);
        int result=Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int cur=queue.poll();
            List<Integer> children=map.get(cur);
            if(children==null)
                result=Math.max(result,(int)value[cur-1]);
            else{
                long pre=value[cur-1];
                for(int num:children) {
                    value[num - 1] = pre * d[num - 1] % mod;
                    while(value[num-1]<0)
                        value[num-1]+=mod;
                    queue.add(num);
                }
            }
        }
        return result;
        // Write your code here
    }

}
