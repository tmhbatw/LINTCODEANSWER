package LINTCODE10;

public class LINTCODE975 {
    /*Description
    * 初始时在记事本上只有一个字符 'A'。你可以在此记事本上每一步可以进行两种操作：
    * Copy All: 你可以复制记事本上所有的字符（不允许部分复制）
    * Paste: 你可以粘贴上一次复制的字符。
    * 给出一个数字 n。你需要在记事本上得到恰好 n 个 'A'， 请问最少需要几步。
    * */

    public int minSteps(int n) {
        if(n==1)
            return 0;
        if(n<=5)
            return n;
        int[] dp=new int[n+1];
        for(int i=2;i<=5;i++)
            dp[i]=i;
        for(int i=6;i<=n;i++){
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0) {
                    dp[i] = dp[i / j] + j;
                    break;
                }
            }
            if(dp[i]==0)
                dp[i]=i;
        }
        return dp[n];
        // Write your code here
    }
}
