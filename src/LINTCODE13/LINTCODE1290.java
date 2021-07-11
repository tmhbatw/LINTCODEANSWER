package LINTCODE13;

import java.util.Arrays;

public class LINTCODE1290 {
    /*Description
    * 给出一个排好序的正整数数组nums和一个整数n，向数组添加/patch元素，使得范围[1, n]
    * 包含的任何数字都可以由数组中某些元素的总和形成。 返回所需的最少补齐数。
    * */

    public int minPatches(int[] nums, int n) {
        long cur=1;
        int res=0;
        int index=0;
        while(cur<=n){
            if(index<nums.length&&nums[index]<=cur)
                cur+=nums[index++];
            else{
                res++;
                cur*=2;
            }
        }
        return res;
        // Write your code here
    }
}
