package LINTCODE17;

public class LINTCODE1611 {
    /*Description
    * 给定一个正整数数组和一个整数K，找到一个长度最短的连续子数组使得这个子数组的和大于等于K，如果不存在，返回 -1
    * */

    public int smallestLength(int[] nums, int k) {
        int result=Integer.MAX_VALUE;
        int start=0;
        int curSum=0;
        for(int i=0;i<nums.length;i++){
            curSum+=nums[i];
            while(curSum>=k){
                result=Math.min(i-start+1,result);
                curSum-=nums[start++];
            }

        }
        return result==Integer.MAX_VALUE?-1:result;
        // Write your code here
    }
}
