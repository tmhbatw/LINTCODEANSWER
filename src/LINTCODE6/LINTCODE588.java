package LINTCODE6;

import java.util.Arrays;

public class LINTCODE588 {
    /*Description
    * 给一 只含有正整数 的 非空 数组, 找到这个
    * 数组是否可以划分为 两个 元素和相等的子集。
    * */
    public boolean canPartition(int[] nums) {
        if (nums.length == 0)
            return true;
        Arrays.sort(nums);
        int sum = 0;
        for (int cur : nums)
            sum += cur;
        if (sum % 2 == 1)
            return false;
        sum /= 2;
        int[] dp = new int[nums.length + 1];
        for (int j = nums.length - 1; j >= 0; j--) {
            int cur = nums[j];
            int max = 0;
            for (int i = nums.length; i > j; i--) {
                if (sum - cur >= dp[i]) {
                    max = Math.max(max, cur + dp[i]);
                }
            }
            if (dp[j] == sum)
                return true;
            dp[j] = max;
        }
        System.out.println(Arrays.toString(dp));
        return false;
        // write your code here
    }
}
