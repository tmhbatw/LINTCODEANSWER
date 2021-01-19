package LINTCODE8;

public class LINTCODE724 {
    /*Description
    * 给出一个正整数数组，写一个程序把这个整数数组分成S1跟S2两部分，使S1中的和跟S2中的和的差的绝对值最小。
    * 句话讲，如果有一个一个整数数组 S 有 n 个数，如果Subset1有 m 个数，Subset2必须有 n-m 个数并且 abs(sum(Subset1) – sum(Subset2)) 应该最小
    * */

    public int findMin(int[] nums) {
        int sum=0;
        for(int cur:nums)
            sum+=cur;
        boolean[] dp=new boolean[sum/2+1];
        dp[0]=true;
        for(int cur:nums){
            for(int j=sum/2;j>=0;j--) {
                if(j>=cur)
                    dp[j] |= dp[j - cur];
            }
        }
        for(int j=sum/2;j>=0;j--){
            if(dp[j])
                return sum-j*2;
        }
        return 0;
        // write your code here
    }
}
