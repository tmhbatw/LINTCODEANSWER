package LINTCODE13;

import java.util.*;

public class LINTCODE1288 {
    /*Description
    *给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，
    * 对该行程进行重新规划排序。所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。
    * */

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map=new HashMap<>();
        for(List<String> list:tickets){
            map.putIfAbsent(list.get(0),new PriorityQueue<>());
            map.get(list.get(0)).add(list.get(1));
        }
        List<String> result=new ArrayList<>();
        dfs(result,"JFK",map);
        Collections.reverse(result);
        return result;
        // Write your code here
    }

    private void dfs(List<String> result,String cur,Map<String,PriorityQueue<String>> map){
        PriorityQueue<String> q=map.getOrDefault(cur,new PriorityQueue<>());
        while(!q.isEmpty()){
            String next=q.poll();
            dfs(result,next,map);
        }
        result.add(cur);
    }
}
