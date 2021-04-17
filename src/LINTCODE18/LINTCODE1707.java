package LINTCODE18;

import java.util.Arrays;

public class LINTCODE1707 {
    /*Description
    * 这一次，我们将 “骑士” 放在电话拨号盘的任意数字键（如上图所示）上，接下来，骑士将会跳 N-1 步。每一步必须是从一个数字键跳到另一个数字键。
    * 每当它落在一个键上（包括骑士的初始位置），都会拨出键所对应的数字，总共按下 N位数字。
    * 你能用这种方式拨出多少个不同的号码？
    * 因为答案可能很大，所以输出答案模 10^9 + 7
    * */

    public int knightDialer(int N) {
        int mod=1000000007;
        int[] dp=new int[10];
        Arrays.fill(dp,1);
        int[] curDp=new int[10];
        for(int i=1;i<N;i++){
            curDp[0]=(dp[4]+dp[6])%mod;
            curDp[1]=(dp[6]+dp[8])%mod;
            curDp[2]=(dp[7]+dp[9])%mod;
            curDp[3]=(dp[4]+dp[8])%mod;
            curDp[4]=((dp[0]+dp[3])%mod+dp[9])%mod;
            curDp[6]=((dp[1]+dp[7])%mod+dp[0])%mod;
            curDp[7]=(dp[2]+dp[6])%mod;
            curDp[8]=(dp[1]+dp[3])%mod;
            curDp[9]=(dp[2]+dp[4])%mod;
            dp=Arrays.copyOf(curDp,10);
        }
        int result=0;
        for(int cur:dp){
            result+=cur;
            result%=mod;
        }
        return result;
        //
    }
}
