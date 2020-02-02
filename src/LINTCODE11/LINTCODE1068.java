package LINTCODE11;

public class LINTCODE1068 {
    /*Description
    *给定一个整数数组nums，编写一个返回此数组的“中心索引”的方法。
    * 我们将中心索引定义为：中心索引左边的数字之和等于中心索引右边的数字之和。
    * 如果不存在这样的中心索引，我们应该返回-1。 如果有多个中心索引，则应返回最左侧的那个。
    * */

    public int pivotIndex(int[] nums) {
        int sum=0;
        for(int num:nums)
            sum+=num;
        int preSum=0;
        for(int i=0;i<nums.length;i++){
            sum-=nums[i];
            if(preSum==sum)
                return i;
            preSum+=nums[i];
        }
        return -1;
        // Write your code here
    }
}
