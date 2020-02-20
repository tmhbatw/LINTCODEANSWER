package LINTCODE14;

import java.util.*;

public class LINTCODE1366 {
    /*Description
    * 请你判断一个 n 个点，m 条边的有向图是否存在环。参数为两个int数组，start[i]到end[i]有一条有向边。
    * */

    private boolean isCycle=false;

    public boolean isCyclicGraph(int[] start, int[] end) {
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<start.length;i++){
            List<Integer> list=map.getOrDefault(start[i],new ArrayList<>());
            list.add(end[i]);
            map.put(start[i],list);
        }
        HashSet<Integer> sumSet=new HashSet<>();
        for(int num:start){
            if(isCycle)
                return true;
            if(sumSet.contains(num))
                continue;
            recursion(map,new HashSet<>(),num,sumSet);
        }
        return isCycle;
        // Write your code here
    }

    private void recursion(HashMap<Integer,List<Integer>> map, HashSet<Integer> set,int cur,HashSet<Integer> sumSet){
        sumSet.add(cur);
        if(isCycle)
            return;
        if(set.contains(cur)){
            isCycle=true;
            return;
        }
        List<Integer> list=map.getOrDefault(cur,new ArrayList<>());
        HashSet<Integer> curSet=new HashSet<>(set);
        curSet.add(cur);
        for(int num:list){
            recursion(map,curSet,num,sumSet);
        }
    }
}
