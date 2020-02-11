package LINTCODE6;

import java.util.*;

public class LINTCODE506 {
    /*Description
    * 给一个用户看过的电影的列表信息，为每个用户推荐他可能喜欢的其他电影。
    * 这里我们规定一个简单的推荐算法，您需要用Map Reduce的方式实现该算法。
    * 对于某个用户，假如他看过的电影A,B,C，那么我们在看过电影A，B或者C的人中查看这些人看过的电影集合有哪些，
    * 对这些电影求并集，将出现频率最高的最多前5个电影推荐给该用户，被推荐的电影需要按照相关度排序。
    * */



    public List<List<Integer>> minMalwareSpread(List<List<Integer>> graph) {
        HashMap<Integer, HashSet<Integer>> map=new HashMap<>();
        for(int i=0;i<graph.size();i++){
            List<Integer> cur=graph.get(i);
            for(int curr:cur) {
                HashSet<Integer> set = map.getOrDefault(curr, new HashSet<>());
                set.add(i);
                map.put(curr,set);
            }
        }
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<graph.size();i++){
            List<Integer> list=graph.get(i);
            HashSet<Integer> relate=new HashSet<>();
            for(int cur:list){
                relate.addAll(map.get(cur));
            }
            HashMap<Integer,Integer> curMap=new HashMap<>();
            for(int cur:relate){
                List<Integer> curList=graph.get(cur);
                for(int num:curList){
                    curMap.put(num,curMap.getOrDefault(num,0)+1);
                }
            }
            HashSet<Integer> repeat=new HashSet<>(list);
            PriorityQueue<Map.Entry> queue=new PriorityQueue<>(new Comparator<Map.Entry>() {
                @Override
                public int compare(Map.Entry o1, Map.Entry o2) {
                    if((int)o1.getValue()==(int) o2.getValue())
                        return (int)o1.getKey()-(int)o2.getKey();
                    return (int)o2.getValue()-(int)o1.getValue();
                }
            });
            for(Map.Entry entry:curMap.entrySet()){
                int num=(int)entry.getKey();
                if(repeat.contains(num))
                    continue;
                queue.add(entry);
            }
            List<Integer> res=new ArrayList<>();
            int time=5;
            while(!queue.isEmpty()&&time-->0){
                res.add((int)queue.poll().getKey());
            }
            result.add(res);
        }
        return result;
    }
}
