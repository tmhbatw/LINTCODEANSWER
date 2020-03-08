package LINTCODE7;

public class LINTCODE604 {
    /*Description
    * 给你一个大小为n的整型数组和一个大小为k的滑动窗口，将滑动窗口从头移到尾，输出从开始到结束每一个时刻滑动窗口内的数的和。
    * */

    public int[] winSum(int[] nums, int k) {
        if(k==0||nums.length<k)
            return new int[0];
        int[] result=new int[nums.length-k+1];
        int curSum=0;
        for(int i=0;i<k-1;i++){
            curSum+=nums[i];
        }
        for(int i=k-1;i<nums.length;i++){
            curSum+=nums[i];
            result[i-k+1]=curSum;
            curSum-=nums[i-k+1];
        }
        return result;
        // write your code here
    }
}
