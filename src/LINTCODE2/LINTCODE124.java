package LINTCODE2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LINTCODE124 {
    /*Description
    * 给定一个未排序的整数数组，找出最长连续序列的长度。
    * */

    /*Solution
    * 用一个set保存数组，判断每一个数的前后数字是否在set中
    * 记录最大之和并将该列数字去掉以减少重复计算操作
    * */

    public int longestConsecutive(int[] num) {
        Set<Integer> set=new HashSet<>();
        for(int i:num)
            set.add(i);
        int max=1;
        for(int i:num){
            if(!set.contains(i))
                continue;
            int l = i- 1;
            while (set.remove(l)) l--;

            int h = i + 1;
            while (set.remove(h)) h++;

            max= Math.max(max, h - l - 1);

        }
        return max;
        // write your code here
    }
/*    public int longestConsecutive(int[] num) {
        Set<Integer> set=new HashSet<>();
        for(int i:num)
            set.add(i);
        int max=1;
        for(int i:num){
            if(!set.contains(i))
                continue;
            int min=1;
            int nu=i;
            while(set.remove(--i))
                min++;
            while(set.remove(++nu))
                min++;
            max=Math.max(min,max);

        }
        return max;
        // write your code here
    }*/
}
