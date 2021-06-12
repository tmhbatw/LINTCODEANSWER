package LINTCODE13;

import java.util.Arrays;

public class LINTCODE1291 {
    /*Description
    * 运动会要来了，小红作为拉拉队长，要在每个项目中为参赛同学加油助威。
    * 小红需要遵守以下规则：1.给每个体育项目加油时长必须超过项目时长的一半，每个项目只能加油一次
    * 2.体育项目的开始和结束时间都是整点，小红选择进入项目和离开的时间也必须是整点
    * 3.不考虑往返于各个体育项目比赛场地中花费的时间
    * 现在给出所有项目的起止时间，小红想知道自己能不能在每个项目中都为同学加油呢？
    * 若可以则返回1，或不行则返回-1.
    * */

    public int CheerAll(int[][] Events) {
        int length=Events.length;
        int[][] dp=new int[length][4];
        for(int i=0;i<length;i++){
            dp[i][0]=Events[i][0];
            dp[i][1]=Events[i][1];
            dp[i][2]=(dp[i][1]-dp[i][0])/2+1;
            dp[i][3]=dp[i][1]-dp[i][2];
        }
        Arrays.sort(dp,(o1,o2)->{
            if(o1[3]==o2[3])
                return o1[2]-o2[2];
            return o1[3]-o2[3];
        });
        int start=0;
        for(int[] cur:dp){
            if(start>cur[3])
                return -1;
            start=Math.max(start,cur[0]);
            start+=cur[2];
        }
        return 1;
        // write your code here
    }
}
