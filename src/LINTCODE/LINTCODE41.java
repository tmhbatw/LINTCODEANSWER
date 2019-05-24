package LINTCODE;

public class LINTCODE41 {
    /*Description
    * 给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
    * */

    /*Solution
    * 创建一个数组保存当前数之前的最大数字和
    * */

    public int maxSubArray(int[] nums) {
        //保存最大和的数组
        int[] result=new int[nums.length];
        result[0]=nums[0];
        //保存结果数组
        int res=nums[0];
        for(int i=1;i<nums.length;i++){
            result[i]=result[i-1]<0?nums[i]:result[i-1]+nums[i];
            res=Math.max(res,result[i]);
        }
        return res;
        // write your code here
    }
}
