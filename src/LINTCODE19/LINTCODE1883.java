package LINTCODE19;

import java.util.*;

public class LINTCODE1883 {
    /*Description
    * 给定一个评论列表reviews，一个关键字列表 keywords 以及一个整数k。
    * 找出在不同评论中出现次数最多的前k个关键词，这k个关键词按照出现次数的由多到少来排序。
    * 字符串不区分大小写，如果关键字在不同评论中出现的次数相等，请按字母顺序从小到大排序。
    * */

    public List<String> TopkKeywords(int K, String[] keywords, String[] reviews) {
        Map<String,Integer> map=new HashMap<>();
        for(String cur:keywords){
            cur=cur.toLowerCase();
            map.put(cur,0);
        }
        for(String cur:reviews){
            String[] curr=cur.replaceAll("\\pP","").toLowerCase().split(" ");
            Set<String> set=new HashSet<>(Arrays.asList(curr));
            for(String s:set){
                if(map.containsKey(s))
                    map.put(s,map.get(s)+1);
            }
        }
        PriorityQueue<Map.Entry> queue=new PriorityQueue<>(new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                int entryNumber1= (int) o1.getValue();
                int entryNumber2= (int) o2.getValue();
                if(entryNumber1==entryNumber2)
                    return o1.getKey().toString().compareTo(o2.getKey().toString());
                return entryNumber2-entryNumber1;
            }
        });
        for(Map.Entry curr:map.entrySet())
            queue.add(curr);
        List<String> result=new ArrayList<>();
        while(!queue.isEmpty()&&K-->0)
            result.add(queue.poll().getKey().toString());
        return result;
        // write your code here
    }

    public static void main(String[] args){
        String s="sdasdf.,][]as1";
        String ss=s.replaceAll("\\pP", "").toLowerCase();
        System.out.println(ss);
    }
}
