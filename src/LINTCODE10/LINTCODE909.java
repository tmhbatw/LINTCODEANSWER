package LINTCODE10;

import java.util.*;

public class LINTCODE909 {
    /*Description
    *给定一个Android 3x3锁定屏幕和两个整数m和n,其中1≤m≤n≤9,统计可以解锁Android锁定屏幕所有有效模式的总数,包括最少的m个键和最多n个键。
    * 有效模式的规则:每个模式必须连接至少m个键和最多n个键。所有的键都必须是不同的。
    * 如果在模式中连接两个连续键的行通过任何其他键，则其他键必须在模式中选择。不允许跳过非选择键。
    * 钥匙的顺序很重要。
    * */

    int result= 0;
    Map<Integer,Integer> map=new HashMap<>();
    int m;
    int n;
    public int numberOfPatterns(int m, int n) {
        fillMap();
        this.m=m;
        this.n=n;
        Set<Integer> set=new HashSet<>();
        for(int i=1;i<=9;i++) {
            set.add(i);
        }
        for(int i=1;i<=9;i++) {
            set.remove(i);
            dfs(i, 1,set);
            set.add(i);
        }
        return 0;
        // Write your code here
    }

    private void dfs(int cur,int time,Set<Integer> set){
        if(time>=n&&time<=m)
            result++;
        if(time==m)
            return;
        for (int next : set) {
            if (set.contains(map.get(cur * 10 + next)))
                continue;
            Set<Integer> curSet=new HashSet<>(set);
            curSet.remove(next);
            dfs(next, time + 1, curSet);
            set.add(next);
        }

    }

    private void fillMap(){
        for(int i=1;i<=9;i++){
            for(int j=1;j<=9;j++){
                map.put(i*10+j,0);
            }
        }
        map.put(13,2);
        map.put(17,2);
        map.put(19,5);
        map.put(28,5);
        map.put(31,2);
        map.put(37,5);
        map.put(39,6);
        map.put(46,5);
        map.put(64,5);
        map.put(71,4);
        map.put(73,5);
        map.put(79,8);
        map.put(82,5);
        map.put(91,5);
        map.put(93,6);
        map.put(97,8);
    }

}
