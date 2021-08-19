package LINTCODE9;

import java.util.Arrays;

public class LINTCODE818 {
    /*Description
    *给一个数组，给定一个target，求满足以下条件的子集个数：
    * 条件：子集中的最小值+最大值小于给定target。
    * */


    public long subsetWithTarget(int[] nums, int target) {
        Arrays.sort(nums);
        long result=0;
        int length=nums.length;
        for(int i=0;i<length;i++){
            if(nums[i]+nums[i]>=target)
                continue;
            int end=i;
            while(end+1<length&&nums[end+1]+nums[i]<target)
                end++;
            long time=getRes(nums,i,end);
            result+=time;
        }
        return result;
        // Write you code here
    }


    private long getRes(int[] nums,int start, int end){
        return (long) Math.pow(2,end-start);
    }
}
