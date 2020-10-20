package LINTCODE19;

import java.util.Arrays;

public class LINTCODE1897 {
    /*Description
    * 你有一个当前会议列表intervals，里面表明了每个会议的开始和结束时间，以及一些会议室rooms。
    * 现在有一系列会议ask需要加入，逐个判断他们能否被安排进当前的会议列表中而不产生冲突。一个会议室在同一时间只能进行一场会议。每个询问都相互独立。
    * */

    public boolean[] meetingRoomIII(int[][] intervals, int rooms, int[][] ask) {
        int[] dp=new int[50000+2];
        int[] match=new int[50002];
        for(int[] cur:intervals){
            dp[cur[0]]++;
            dp[cur[1]]--;
        }
        for(int i=1;i<50002;i++){
            dp[i]+=dp[i-1];
            match[i]+=match[i-1];
            if(dp[i]>=rooms)
                match[i]++;
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(match));
        boolean[] result=new boolean[ask.length];
        int index=0;
        for(int[] cur:ask){
            if(match[cur[1]-1]-match[cur[0]-1]==0)
                result[index++]=true;
            else
                result[index++]=false;
        }
        return result;
        // Write your code here.
    }
}
