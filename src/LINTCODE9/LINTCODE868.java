package LINTCODE9;

public class LINTCODE868 {
    /*Description
    *给定一个由n个整数组成的数组，找到给定长度k的连续子数组，该子数组具有最大平均值。你需要输出最大平均值。
    * */

    /*Solution
    * 滑动窗口
    * */

    public double findMaxAverage(int[] nums, int k) {
        int curSum=0;
        for(int i=0;i<k;i++)
            curSum+=nums[i];
        double max=curSum;
        for(int i=0;i<nums.length-k;i++){
            curSum=curSum-nums[i]+nums[i+k];
            max=Math.max(max,curSum);
        }
        return max/k;
        // Write your code here
    }
}
