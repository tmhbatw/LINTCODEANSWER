package LINTCODE9;

import datastructure.Point;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE826 {
    /*Description
    * 一个n * m矩阵代表一个电脑的阵列，给你一个list< Point >代表坏掉的电脑坐标。现在我们从(0,0)出发修电脑，要求
    * 1.必须修完当前行所有坏掉的电脑才能走向下一行。
    * 2.如果要走向下一行，修理工必须先返回到这一行的最左端或者最右端。
    * 求最短的访问距离。
    * */

    public int maintenance(int n, int m, Point[] badcomputers) {
        Map<Integer,Integer> big=new HashMap<>();
        Map<Integer,Integer> small=new HashMap<>();
        for(Point cur:badcomputers){
            int x=cur.x;
            int y=cur.y;
            big.putIfAbsent(x,Integer.MIN_VALUE);
            big.put(x,Math.max(y,big.get(x)));
            small.putIfAbsent(x,Integer.MAX_VALUE);
            small.put(x,Math.min(small.get(x),y));
        }
        int[][] dp=new int[n][2];
        dp[0][1]=m-1;
        dp[0][0]=big.getOrDefault(0,0)*2;
        for(int i=1;i<n;i++){
            dp[i][0]=Math.min(dp[i-1][1]+m-1,dp[i-1][0]+big.getOrDefault(i,0)*2);
            dp[i][1]=Math.min(dp[i-1][0]+m-1,dp[i-1][1]+(m-1-small.getOrDefault(i,m-1))*2);
        }
        return Math.min(dp[n-1][0],dp[n-1][1])+n-1;
        // Write your code here
    }

    public static void main(String[] args){
        Point[] p=new Point[3];
        p[0]=new Point(0,0);
        p[1]=new Point(0,9);
        p[2]=new Point(1,7);
        System.out.println(new LINTCODE826().maintenance(3,10,p));
    }
}
