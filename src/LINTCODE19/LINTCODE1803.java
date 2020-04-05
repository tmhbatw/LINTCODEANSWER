package LINTCODE19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE1803 {
    /*Description
    *给定若干个二维坐标点，在原点发出一个光束，光束有一个固定夹角而且可以绕原点旋转，
    * 返回光束最多可以照到坐标点的个数。
    * */

    public int AngleBeam(int[][] points, int angle) {
        int length=points.length;
        double[] dp=new double[length*2];
        for(int i=0;i<length;i++){
            double degree=getAngle(points[i][0],points[i][1]);
            dp[i]=degree;
            dp[i+length]=degree+360;
        }
        Arrays.sort(dp);
        int left=0;
        int result=0;
        for(int i=0;i<length*2;i++){
            while(dp[i]-dp[left]>angle){
                left++;
            }
            result=Math.max(result,i-left+1);
        }
        return result;
        // write your code here
    }

    private static double getAngle(int x,int y){
        if(x==0)
            return y>0?90:270;
        if(y==0)
            return x>0?0:180;
        double degree =Math.toDegrees (Math.atan (y*1.0/x));
        if(x>0&&y<0)
            return degree+360;
        if(x<0)
            return degree+180;
        return degree;
    }

    public static void main(String[] args){
        System.out.println(getAngle(-1,0));

    }

}
