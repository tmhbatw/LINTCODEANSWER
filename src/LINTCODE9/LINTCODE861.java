package LINTCODE9;

import java.util.TreeSet;

public class LINTCODE861 {
    /*Description
    * 一个花园有N个位置。每个位置上有一朵花。这N朵花会在N天内逐一盛开。每天都一定会有并且只有一朵花盛开，
    * 从这天起，这朵花将一直处于盛开的状态。
    * 给定一个由数字1到N组成的数组flowers。数组中的每个数字表示那一天将会盛开的花的位置。
    * 例如，flowers[i] = x表示在位置x上的花会在第i天盛开，其中i和x都在1到N的范围内。
    * 还有，给出一个整数k，你需要返回，在哪一天，恰好有两朵花处于盛开的状态，并且两朵花之间恰好有k朵花没有盛开。
    * 如果有多个答案，选择最小的。
    * 如果不存在这样一天，那么返回-1。
    * */

    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<flowers.length;i++){
            Integer big;
            if((big=set.ceiling(flowers[i]+1))!=null){
                if(big-flowers[i]==k)
                    return i+1;
            }
            Integer small;
            if((small=set.floor(flowers[i]+1))!=null){
                if(flowers[i]-small==k)
                    return i+1;
            }
            set.add(flowers[i]);
        }
        return -1;
        // Write your code here
    }

    public static void main(String[] args){
        TreeSet<Integer> set=new TreeSet<>();
        set.add(1);
        set.add(2);
        System.out.println(set.ceiling(2));
        System.out.println(set.ceiling(3));
    }
}
