package LINTCODE20;

import java.util.*;

public class LINTCODE1914 {
    /*Description
    * 销售主管的任务是出售一系列的物品，其中每个物品都有一个编号。
    * 由于出售具有相同编号的商品会更容易，所以销售主管决定删除一些物品。
    * 现在她知道她最多能删除多少物品，她想知道最终袋子里最少可以包含多少种不同编号的物品。
    * 例如，最开始她有n = 6 个物品，编号为：ids = [1,1,1,2,2,3]，她最多可以删除 m = 2 个物品。
    * 如果删除两个物品 1，则剩下的物品 ids = [1,2,2,3]，此时她拥有三种不同编号的物品。
    * 如果删除两个物品 2，则剩下的物品 ids = [1,1,1,3]，此时她拥有两种不同编号的物品。
    * 如果删除物品 2 和物品 3 各 1个，则剩下的物品 ids = [1,1,1,2]，此时她拥有两种不同编号的物品。
    * 我们发现，物品最多可以剩下两种不同的编号，所以你的程序要返回 2
    * */

    public int minItem(List<Integer> ids, int m) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int cur:ids)
            map.put(cur,map.getOrDefault(cur,0)+1);
        Collection cur= map.values();
        List<Integer> list=new LinkedList<>(cur);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        int index=0;
        int size=list.size();
        int result=size;
        while(index<size&&list.get(index)<=m){
            m-=list.get(index++);
            result--;
        }
        return result;
        // write your code here
    }

}
