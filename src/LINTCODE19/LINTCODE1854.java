package LINTCODE19;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LINTCODE1854 {
    /*Description
    * 给你一个整数数组和一个整数K，请你判断数组是否可以划分为若干大小为k序列，并满足以下条件：
    * 数组中的每一个数恰恰出现在一个序列中
    * 一个序列中的数都是互不相同的
    * 数组中相同元素是被划分到不同序列中的
    * 如何可以划分，返回True，否则返回False。
    * 数组长度小于等于10^5。
    * */

    public boolean partitionArratIII(int[] array, int k) {
        int length=array.length;
        if(length%k!=0)
            return false;
        Map<Integer,Integer> map=new HashMap<>();
        length/=k;
        for(int num:array) {
            int cur=map.getOrDefault(num,0)+1;
            if(cur>length)
                return false;
            map.put(num, cur);
        }
        return true;
        // write your code here
    }
}
