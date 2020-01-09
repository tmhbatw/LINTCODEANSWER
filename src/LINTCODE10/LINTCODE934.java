package LINTCODE10;

public class LINTCODE934 {
    /*Description
    *给一个整数数组 nums，求出下标从 i 到 j 的元素和(i ≤ j)，i 跟 j对应的元素也包括在内。
    * */

    /*Solution
    * 保留一个前缀数组之和
    * */


    class NumArray {

        int[] prefixSum;
        public NumArray(int[] nums) {
            prefixSum=new int[nums.length+1];
            for(int i=0;i<nums.length;i++){
                prefixSum[i+1]=prefixSum[i]+nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return prefixSum[j+1]-prefixSum[i];
        }
    }
}
