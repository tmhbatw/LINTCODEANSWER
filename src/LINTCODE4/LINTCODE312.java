package LINTCODE4;

import java.util.Arrays;

public class LINTCODE312 {
    /*Description
    * 小强在玩扑克牌,扑克牌(去掉大小王)是由数字1-13各四种花色组成的。但是小强觉得只有52张牌并不快乐,
    * 于是他决定创造一种牛牌,牛牌是由数字1-n各四种花色组成的,但是小强手上只有一只黑色水笔，
    * 画不出四种不同的花色,因此他只能创造出数字1ーn各四张牌。现在小强想知道,当他手上有m张牌时,
    * 这m张牌一共有多少种牌型。(当且仅当某个数字在两种牌型中的数量不同时，这两种牌型是不同的)
    * */

    /*Solution
    * 动态规划
    * */

    public int bullCards(int n, int m) {
        int[][][] dp=new int[n+1][m+1][5];
        for(int i=1;i<=4;i++){
            if(i>m)
                break;
            dp[1][i][i]=1;
        }
        for(int i=1;i<=n;i++)
            dp[i][0][0]=1;
        int mod=1000000007;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=m;j++){
                for(int k=0;k<=4;k++){
                    if(k>j)
                        break;
                    dp[i][j][k]=((dp[i-1][j-k][0]+(dp[i-1][j-k][1]+dp[i-1][j-k][2])%mod)%mod+(dp[i-1][j-k][3]+dp[i-1][j-k][4])%mod)%mod;
                }
            }
        }
        for(int i=1;i<=n;i++){
            System.out.println("此时有"+i+"张卡片");
            for(int j=1;j<=m;j++){
                System.out.print(Arrays.toString(dp[i][j]));
            }
        }
        return ((dp[n][m][0]+dp[n][m][1])%mod+((dp[n][m][2]+dp[n][m][3])%mod+dp[n][m][4])%mod)%mod;
        // Write your code here.
    }
}
