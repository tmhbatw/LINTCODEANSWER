package LINTCODE11;

import java.util.*;

public class LINTCODE1020 {
    /*Description
    * 给定N个节点的有向无环图。 查找从节点0到节点N-1的所有可能的路径，你可以以任何顺序返回它们。
    * 该图给出方式如下：节点为0, 1，…，graph.length - 1。 graph[i]是一个列表，其中的任一个元素j表示图中含有一条 i->j 的有向边。
    * */

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result=new ArrayList<>();
        recursion(result, new ArrayList<Integer>(),0,graph,graph.length-1);
        return result;
        // Write your code here
    }

    private void recursion(List<List<Integer>> result, List<Integer> res, int curId, int[][] graph,int target){
        List<Integer> curRes=new ArrayList<>(res);
        curRes.add(curId);
        if(curId==target){
            result.add(curRes);
            return;
        }
        int[] curNum=graph[curId];
        for(int cur:curNum){
            recursion(result,curRes,cur,graph,target);
        }
    }
}
