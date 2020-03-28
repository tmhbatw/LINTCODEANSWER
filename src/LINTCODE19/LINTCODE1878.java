package LINTCODE19;

public class LINTCODE1878 {
    /*Description
    * 我们称X为好数当整个数字绕平面内任一点旋转180°之后仍是其本身，例如“1”，“2”，“0”，"12021","69","96"。特别要注意的是，
    * 我们使用的数字跟我们在红绿灯上使用的是一样的。
    * 给你长度n,我们需要统计长度为n的好数有多少个。
    * */

    /*Solution
    *     // f[n] is n digits how many rotates nums
    // f[n] = f[n - 2] * 7
    // f[0] = 0
    // f[1] = 5
    // f[2] = 6
    // ans is f[n - 1] * 6
    * */
    public long RotatedNums(int n) {
        if(n==1)
            return 5;
        if(n==2)
            return 6;
        long[] dp=new long[n];
        dp[0]=0;
        dp[1]=5;
        dp[2]=7;
        for(int i=3;i<n-1;i++)
            dp[i]=dp[i-2]*7;
        return dp[n-2]*6;
        // write your code here
    }
}
