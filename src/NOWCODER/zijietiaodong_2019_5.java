package NOWCODER;

import java.util.Arrays;
import java.util.Scanner;

public class zijietiaodong_2019_5 {
    /*Description
    *城市个数n（1<n≤20，包括北京）
    * 城市间的车票价钱 n行n列的矩阵 m[n][n]
    *  最小车费花销 s
    * */

    /*Solution
    * 动态规划超时了
    * */
    private static int min=Integer.MAX_VALUE;

    private static int times;

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int cityNum=s.nextInt();
        times=cityNum;
        int[][] price=new int[cityNum][cityNum];
        for(int i=0;i<cityNum;i++){
            for(int j=0;j<cityNum;j++){
                price[i][j]=s.nextInt();
            }
        }
        recursion(price,0,1,0);
        System.out.println(min);
    }

    private static void recursion(int[][] prices,int curPos,int time,int price){
        if(time==times){
            price+=prices[curPos][0];
            min=Math.min(min,price);
            return;
        }
        for(int i=1;i<times;i++){

            if(prices[curPos][i]==0)
                continue;
            int[][] pri=new int[times][times];
            for(int j=0;j<times;j++){
                pri[j]=prices[j].clone();
                pri[j][i]=0;
            }
            recursion(pri,i,time+1,price+prices[curPos][i]);
        }
    }

}
