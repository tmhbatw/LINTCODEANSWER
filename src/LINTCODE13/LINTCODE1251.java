package LINTCODE13;

public class LINTCODE1251 {

    /*Description
    * 给定一个由非负整数组成的数组和一个整数m，我们要把数组拆分为m个非空连续子数组。
    * 编写算法以最小化这些m个子阵列中的最大总和。
    * */

    public int splitArray(int[] nums, int m) {
        int l=Integer.MIN_VALUE,r=0;
        for(int cur:nums){
            l=Math.max(l,cur);
            r+=cur;
        }
        while(l<r){
            int mid=l+(r-l)/2;
            if(isMatch(nums,mid,m))
                r=mid;
            else
                l=mid+1;
        }
        return l;
        // write your code here
    }

    private boolean isMatch(int[] nums,int cur,int m){
        int length=nums.length;
        int count=0;
        for(int i=0;i<length;i++){
            int curSum=nums[i];
            count++;
            while(i<length-1&&curSum+nums[i+1]<=cur){
                curSum+=nums[++i];
            }
        }
        return count<=m;
    }
}
