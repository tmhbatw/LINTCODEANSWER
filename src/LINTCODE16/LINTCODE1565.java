package LINTCODE16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LINTCODE1565 {
    /*Description
    * 有一个一维的棋盘，起点在棋盘的最左侧，终点在棋盘的最右侧，棋盘上有几个位置是跟其他的位置相连的，
    * 即如果A与B相连，则当棋子落在位置A时, 你可以选择是否不投骰子，直接移动棋子从A到B。并且这个连接是单向的，
    * 即不能从B移动到A，现在给定这个棋盘的长度length和位置的相连情况connections，你有一个六面的骰子(点数1-6)，最少需要丢几次才能到达终点。
    * */

    public int modernLudo(int length, int[][] connections) {
        if(length==1)
            return 0;
        if(length<=7)
            return 1;
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int[] cur:connections){
            List<Integer> list=map.getOrDefault(cur[1],new ArrayList<>());
            list.add(cur[0]);
            map.put(cur[1],list);
        }
        int[] dp=new int[length+1];
        dp[1]=0;
        dp[2]=1;
        dp[3]=1;
        dp[4]=1;
        dp[5]=1;
        dp[6]=1;
        dp[7]=1;
        for(int i=8;i<=length;i++){
            dp[i]=dp[i-1]+1;
            for(int j=2;j<=6;j++){
                dp[i]=Math.min(dp[i],dp[i-j]+1);
            }
            List<Integer> list=map.getOrDefault(i,new ArrayList<>());
            for(int cur:list){
                dp[i]=Math.min(dp[i],dp[cur]);
            }
        }
        return dp[length];
        // Write your code here
    }
}
