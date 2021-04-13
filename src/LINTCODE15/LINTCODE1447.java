package LINTCODE15;

import java.awt.*;
import java.util.Arrays;

public class LINTCODE1447 {
    /*Description
    * 输入一个矩阵的长度为 l，宽度为 w，和三个必经点，问有多少种方法可以从左上角走到右下角（每一步，只能向右或者向下走）
    * ，输入保证合法，有解。答案对 1000000007 取模。
    * */
    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
    public static final int mod=1000000007;
    public long calculationTheSumOfPath(int l, int w, Point[] points) {
        Point[] p=new Point[5];
        for(int i=0;i<3;i++)
            p[i]=points[i];
        p[3]=new Point(1,1);
        p[4]=new Point(l,w);
        Arrays.sort(p,(o1,o2)->{
            if(o1.x==o2.x)
                return o1.y-o2.y;
            return o1.x-o2.x;
        });
        long result=1;
        for(int i=1;i<5;i++){
            result*=getVal(p[i-1],p[i]);
            result%=mod;
        }
        return result;
        // Write your code here
    }
    private long getVal(Point a,Point b){
        if(b.x<a.x||b.y<a.y)
            return 0;
        if(a.x==b.x||a.y==b.y)
            return 1;
        int[][] dp=new int[b.x-a.x][b.y-a.y];
        for(int i=0;i<dp.length;i++)
            dp[i][0]=1;
        for(int j=1;j<dp[0].length;j++)
            dp[0][j]=1;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                dp[i][j]%=mod;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
