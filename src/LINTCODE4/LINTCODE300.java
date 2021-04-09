package LINTCODE4;

import java.util.Arrays;

public class LINTCODE300 {
    /*Description
    * 给定一系列会议的开始时间、结束时间[[s1,e1]，[s2,e2]，…(si < ei)及他们的价值。
    * 你在同一时刻只能参加一个会议，请问你可以获得的最大价值是多少？
    * */

    public int maxValue(int[][] meeting, int[] value) {
        int[][] meetingWithValue=new int[meeting.length][3];
        for(int i=0;i<meeting.length;i++){
            meetingWithValue[i][0]=meeting[i][0];
            meetingWithValue[i][1]=meeting[i][1];
            meetingWithValue[i][2]=value[i];
        }
        Arrays.sort(meetingWithValue,(o1,o2)->{
            if(o1[0]==o2[0])
                return o1[1]-o2[1];
            return o1[0]-o2[0];
        });
        for(int[] cur:meetingWithValue)
            System.out.println(Arrays.toString(cur));
        int maxTime=0;
        for(int []cur:meeting){
            maxTime=Math.max(maxTime,cur[1]);
        }
        int[] dp=new int[maxTime+1];
        int pre=0;
        for(int[] cur:meetingWithValue){
            while(pre<cur[0]){
                pre++;
                dp[pre]=Math.max(dp[pre-1],dp[pre]);
            }
            dp[cur[1]]=Math.max(dp[cur[1]],dp[cur[0]]+cur[2]);
            System.out.println(dp[cur[0]]+"  "+dp[cur[1]]);
        }
        for(int i=pre;i<=maxTime;i++)
            dp[i]=Math.max(dp[i],dp[i-1]);
        return dp[maxTime];
        // write your code here
    }
}
