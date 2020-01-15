package LINTCODE14;

import java.util.HashMap;
import java.util.HashSet;

public class LINTCODE1320 {
    /*Description
    * 给定一个整数数组，查找数组是否包含任何重复项。
    * 如果数组中某个值至少出现两次，则函数应返回true，如果每个元素都是不同的，则返回false。
    * */

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int cur:nums){
            if(set.contains(cur))
                return true;
            set.add(cur);
        }
        return false;
        // Write your code here
    }
}
