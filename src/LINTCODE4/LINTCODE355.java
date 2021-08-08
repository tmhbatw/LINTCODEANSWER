package LINTCODE4;

import java.util.Stack;

public class LINTCODE355 {

    /*Description
    * 蜘蛛侠在大楼间穿梭。大楼的高度可以看作是一个从左到右排列的数组。现在蜘蛛侠站在第一栋大楼上，他想跳到最后一栋上。
    * 蜘蛛侠的视野为 k，他可以花费x 点体力，用蛛丝移动到右侧k 幢建筑中第一栋比当前位置高的大楼。
    * 或者蜘蛛侠可以花费y 点体力，跳跃到右侧接下来两栋大楼其中一栋。
    * 请计算蜘蛛侠最少花费多少体力，到达最后一栋上。
    * */

    public long shuttleInBuildings(int[] heights, int k, int x, int y) {
        int length=heights.length;
        int[] nextIndex=new int[length];
        Stack<int[]> s=new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!s.isEmpty()&&s.peek()[0]<heights[i]){
                if(i-s.peek()[1]<=k) {
                    nextIndex[s.pop()[1]] = i;
                }else{
                    s.pop();
                }
            }
            s.add(new int[]{heights[i],i});
        }
        long[] dp=new long[length];
        if(nextIndex[0]!=0){
            dp[nextIndex[0]]=x;
        }
        dp[1]=Math.min(y,dp[1]==0?Long.MAX_VALUE:dp[1]);
        if(nextIndex[1]!=0){
            dp[nextIndex[1]]=dp[1]+x;
        }
        for(int i=2;i<length;i++){
            dp[i]=Math.min(Math.min(dp[i-1],dp[i-2])+y,dp[i]==0?Long.MAX_VALUE:dp[i]);
            if(nextIndex[i]!=0){
                dp[nextIndex[i]]=Math.min(dp[nextIndex[i]]==0?Long.MAX_VALUE:dp[nextIndex[i]],dp[i]+x);
            }
        }
        return dp[length-1];
        // write your code here.
    }
}
