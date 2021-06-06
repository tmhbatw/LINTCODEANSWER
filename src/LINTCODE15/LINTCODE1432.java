package LINTCODE15;

import java.util.Arrays;

public class LINTCODE1432 {
    /*Description
    * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
    * 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，
    * 其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。
    * 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？
    * */

    public double new21Game(int N, int K, int W) {
        if(N>=K-1+W||K==0)
            return 1.0;
        double[] dp=new double[K+W+1];
        dp[0]=1*1.0/W;
        dp[W+1]-=dp[0];
        for(int i=1;i<K;i++){
            dp[i]+=dp[i-1];
            dp[i+W+1]-=dp[i]/W;
            dp[i]+=dp[i]/W;
        }
        double result=0;
        for(int i=K;i<=N;i++){
            dp[i]+=dp[i-1];
            result+=dp[i];
        }
        System.out.println(Arrays.toString(dp));
        return result;
        // Write your code here.
    }
}
