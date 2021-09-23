package LINTCODE13;

import java.util.*;

public class LINTCODE1298 {
    /*Description
    * 对于一个树状的无向图，选择任何一个节点作为根。这个图就变成了一个有根树。
    * 在所有可能的有根树中，有最小高度的树叫做最小高度树（minimum height trees, MHTs）。
    * 给定这样的图，找出所有的MHTs，返回根标记的数组。
    * 图包含了n个节点，标记从0到n-1。给定n和一个无向边列表edges。每一个边是一组节点标记。
    * 假定没有重复的遍。由于所有的边是无向边，所以[0, 1]和[1, 0]是等价的，所以也不会同时出现在edges当中。
    * */

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            List<Integer> result=new ArrayList<>();
            result.add(0);
            return result;
        }
        int[] num=new int[n];
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(i,new ArrayList<>());

        for(int[] edge:edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            num[edge[0]]++;
            num[edge[1]]++;
        }

        List<Integer> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(num[i]==1)
                result.add(i);
        }
        Queue<Integer> q=new LinkedList<>(result);
        while(!q.isEmpty()){
            System.out.println(result);
            int size=q.size();
            List<Integer> curRes=new ArrayList<>();
            for(int i=0;i<size;i++){
                int cur=q.poll();
                for(int next:map.get(cur)){
                    num[next]--;
                    if(num[next]==1){
                        curRes.add(next);
                        q.add(next);
                    }
                }
            }
            if(q.size()>0)
                result=curRes;

        }
        return result;
        // Wirte your code here
    }
}
