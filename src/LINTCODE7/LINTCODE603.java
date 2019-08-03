package LINTCODE7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LINTCODE603 {
    /*Description
    *给一个由 无重复的正整数 组成的集合，找出满足任意两个元素 (Si, Sj)
    * 都有 Si % Sj = 0 或 Sj % Si = 0 成立的最大子集
    * */

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length==0)
            return Collections.emptyList();
        Arrays.sort(nums);
        int[] time=new int[nums.length];
        int[] dp=new int[nums.length];
        int max=1;
        int index=0;
        for(int i=0;i<nums.length;i++){
            time[i]=1;
            dp[i]=i;
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j]==0){
                    time[i]=time[j]+1;
                    dp[i]=j;
                    if(time[i]>max){
                        max=time[i];
                        index=i;
                    }
                }
            }
        }
        List<Integer> list=new ArrayList<>();
        while(dp[index]!=index){
            list.add(0,nums[index]);
            index=dp[index];
        }
        list.add(0,nums[index]);
        return list;

        // write your code here
    }

}
