package LINTCODE17;

import java.util.*;

public class LINTCODE1647 {
    /*Description
    *给定n个点，m条边的无向图，点的编号是0,1,2...(n-1)，输出从S点出发，到达T点的所有简单路径，输出的简单路径按字典序排序。当一条路径不会经过某个节点超过一次时，称为简单路径。
    * 举例：假如从0号点到2号点有三条路线：[0,1,2]，[0,2]和[0,1,3,2]
    * 则输出为：
    * [[0,1,2],[0,1,3,2],[0,2]]
    * */

    public List<List<Integer>> getPath(int n, int[][] G, int S, int T) {
        Map<Integer, HashSet<Integer>> map=new HashMap<>();
        for(int[] cur:G){
            HashSet<Integer> list1=map.getOrDefault(cur[0],new HashSet<>());
            list1.add(cur[1]);
            map.put(cur[0],list1);
            HashSet<Integer> list2=map.getOrDefault(cur[1],new HashSet<>());
            list2.add(cur[0]);
            map.put(cur[1],list2);
        }
        List<List<Integer>> result=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        recursion(map,result,new ArrayList<>(),set,S,T);
        return result;
        // Write your code here
    }

    private void recursion(Map<Integer,HashSet<Integer>> map,List<List<Integer>> result,List<Integer> res,HashSet<Integer> set,int curNum,int target){
        HashSet<Integer> curSet=new HashSet<>(set);
        curSet.add(curNum);
        List<Integer> curRes=new ArrayList<Integer>(res);
        curRes.add(curNum);
        if(curNum==target){
            result.add(curRes);
            return;
        }
        HashSet<Integer> list=map.getOrDefault(curNum,new HashSet<>());
        for(int num:list){
            if(!curSet.contains(num))
                recursion(map,result,curRes,curSet,num,target);
        }
    }

}
