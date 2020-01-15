package LINTCODE14;

import java.util.HashSet;

public class LINTCODE1319 {
    /*Description
    *给定一个整数的数组和一个整数k，找出数组中是否有两个不同的索引i和j，
    * 使得nums [i] = nums [j]并且i和j之间的差值的绝对值最多为k。
    * */

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<=k&&i<nums.length;i++){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        for(int i=0;i<nums.length-k-1;i++){
            set.remove(nums[i]);
            if(set.contains(nums[i+k+1]))
                return true;
            set.add(nums[i+k+1]);
        }
        return false;
        // Write your code here
    }
}
