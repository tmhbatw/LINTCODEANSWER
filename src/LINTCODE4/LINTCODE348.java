package LINTCODE4;

import java.util.Arrays;

public class LINTCODE348 {
    /*Description
    * 在一场赛车比赛中，一共有三条赛道，初始时你在22号车道。赛车可以在遇到障碍时切换赛道。
    * 在赛道上有一些障碍，它们的位置obstacles 从起点出发由近到远地列出，obstacles[i]代表第 i 个障碍在哪条赛道上。
    * 障碍在赛道上是分散的，即不会同时有两个障碍挡住赛车的去路。请计算出到达终点最少换几次赛道。
    * */


    public int trackSwitching(int[] obstacles) {
        int length=obstacles.length;
        int[][] dp=new int[3][length+1];
        dp[0][0]=dp[2][0]=0;
        for(int i=0;i<length;i++){
            int j=obstacles[i];
            dp[j-1][i+1]=Integer.MAX_VALUE;
            int j1=0,j2=1;
            if(j==1){
                j1=1;
                j2=2;
            }
            if(j==2){
                j1=0;
                j2=2;
            }
            dp[j1][i+1]=Math.min(dp[j1][i],Math.min(dp[j-1][i],dp[j2][i])+1);
            dp[j2][i+1]=Math.min(dp[j2][i],Math.min(dp[j-1][i],dp[j1][i])+1);
        }
        for(int[] cur:dp)
            System.out.println(Arrays.toString(cur));
        return Math.min(dp[0][length],Math.min(dp[1][length],dp[2][length]));
        // write your code here.
    }
}
