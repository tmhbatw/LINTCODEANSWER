package LINTCODE14;

import datastructure.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LINTCODE1381 {
    /*Description
    *在一个数轴上给出n个线段，问选择不超过k个线段，使得这k个线段覆盖的数最多。
    * */

    public int maximumLineCoverage(List<Interval> intervals, int k) {
        int[][] dp=new int[2001][k+1];
        Collections.sort(intervals,(o1,o2)->{
            return o1.start-o2.start;
        });
        int start=1;
        int end=0;
        for(Interval cur:intervals){
            int s=cur.start;
            for(int i=start;i<s;i++){
                for(int j=0;j<=k;j++){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j]);
                }
            }
            start=s;
            for(int i=cur.start;i<=cur.end;i++) {
                for (int j = 1; j <= k; j++) {
                    dp[i][j] = Math.max(dp[i][j], dp[s - 1][j - 1] + i - cur.start + 1);
                }
            }
            end=Math.max(cur.end,end);
        }
        int result=0;
        for(int i=0;i<=2000;i++) {
            for (int j = 0; j <= k; j++)
                result = Math.max(dp[i][j], result);
        }
        return result;
        // Write your code here
    }

    public static void main(String[] args){
        List<Interval> list=new ArrayList<>();
        list.add(new Interval(1,5));
        list.add(new Interval(2,4));
        list.add(new Interval(5,10));
        int k=2;
        System.out.println(new LINTCODE1381().maximumLineCoverage(list,k));
    }
}
