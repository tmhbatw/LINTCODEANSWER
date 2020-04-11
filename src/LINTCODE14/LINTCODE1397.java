package LINTCODE14;

import datastructure.Interval;

import java.util.List;

public class LINTCODE1397 {
    /*Description
    *给出一些区间，问覆盖次数最多的数是多少，如果有多个，输出最小的那个数。
    * */

    public int digitalCoverage(List<Interval> intervals) {
        int[] dp=new int[100000+2];
        for(Interval cur:intervals){
            dp[cur.start]++;
            dp[cur.end+1]--;
        }
        int max=0;
        int result=0;
        for(int i=1;i<=100000;i++){
            dp[i]+=dp[i-1];
            if(dp[i]>max){
                max=dp[i];
                result=i;
            }
        }
        return result;
        // Write your code here
    }
}
