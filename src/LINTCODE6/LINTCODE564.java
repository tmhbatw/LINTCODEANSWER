package LINTCODE6;

import java.util.Arrays;

public class LINTCODE564 {
    /*Description
    * 给出一个都是正整数的数组 nums，其中没有重复的数。从中找出所有的和为 target 的组合个数。
    * */

    /*Solution
    * 需要动态规划一下
    * */
    public static int backPackVI(int[] nums, int target) {
        Arrays.sort(nums);
        int left=0,right=nums.length-1;
        int mid;
        while(true){
            mid=left+(right-left)/2;
            if(mid+1==nums.length||nums[mid]<=target&&nums[mid+1]>target)
                break;
            else if(nums[mid]>target)
                right=mid-1;
            else
                left=mid+1;
        }
        nums=Arrays.copyOf(nums,mid+1);
        int[][] dp=new int[target+1][nums.length+1];

        for(int i=0;i<target+1;i++){
            for(int j=0;j<nums.length+1;j++){
                if(j==nums.length){
                    for(int k=0;k<j;k++) {
                        dp[i][j]+=dp[i][k];
                    }
                    continue;
                }
                if(i==nums[j]){
                    dp[i][j]=1;
                    continue;
                }
                int del=i-nums[j];
                if(del>0)
                    dp[i][j]=dp[del][nums.length];
            }
        }
        return dp[target][nums.length];
        // write your code here
    }

    public static void main(String[] args){
        int[] num=new int[]{1,2,3,4};
        backPackVI(num,2);

    }



    //下为递归回溯解法
/*    private int result=0;
    public int backPackVI(int[] nums, int target) {
        Arrays.sort(nums);
        recursion(nums,0,target);
        return result;
        // write your code here
    }
    private void recursion(int[] nums,int start,int target){
        if(target==0) {
            result++;
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(nums[i]>target)
                break;
            recursion(nums,start,target-nums[i]);
        }
        return;
    }*/
}
