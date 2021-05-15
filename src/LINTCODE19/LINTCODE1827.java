package LINTCODE19;

public class LINTCODE1827 {
    /*Description
    *有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
    * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
    * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
    * 由于答案可能会很大，请返回方案数 模 10的9次方+7 后的结果。
    * */

    public int numWays(int steps, int arrLen) {
        if(steps==1||arrLen==1)
            return 1;
        arrLen=Math.min(steps,arrLen);
        int[] dp=new int[arrLen];
        dp[0]=1;
        int mod=1000000007;
        for(int i=1;i<=steps;i++){
            int[] curDp=new int[arrLen];
            curDp[0]=(dp[0]+dp[1])%mod;
            curDp[arrLen-1]=(dp[arrLen-1]+dp[arrLen-2])%mod;
            for(int j=1;j<dp.length-1;j++){
                curDp[j]=((dp[j-1]+dp[j])%mod+dp[j+1])%mod;
            }
            dp=curDp;
            // System.out.println(Arrays.toString(dp));
        }
        return dp[0];
        // write your code here
    }
}
