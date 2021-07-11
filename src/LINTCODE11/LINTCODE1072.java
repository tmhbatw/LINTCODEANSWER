package LINTCODE11;

import java.util.Arrays;

public class LINTCODE1072 {
    /*Description
    * 给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B)
    * 的距离被定义为 A 和 B 之间的绝对差值。
    * */

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r=nums[nums.length-1]-nums[0];
        while(l<r){
            int mid = l+(r-l+1)/2;
            if(isMatch(nums,mid,k)){
                l = mid;
            }else
                r= mid-1;
        }
        return l;
        // write your code here
    }

    private boolean isMatch(int[] nums, int distance, int k){
        int count=0;
        int length=nums.length;
        for(int i=0;i<length-1;i++){
            if(nums[i+1]-nums[i]>=distance)
                continue;
            int l = i+1, r=length-1;
            while(l<r){
                int mid=l+(r-l+1)/2;
                if(nums[mid]-nums[i]<distance)
                    l = mid;
                else
                    r = mid-1;
            }
            count+=(l-i);
        }

        return count<k;
    }
}
