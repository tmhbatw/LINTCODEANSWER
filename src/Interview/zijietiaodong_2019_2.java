package Interview;

import java.util.Scanner;

public class zijietiaodong_2019_2 {
    /*Description
    * 给定N（可选作为埋伏点的建筑物数）、D（相距最远的两名特工间的距离的最大值）以及可选建筑的坐标，计算在这次行动中，大锤的小队有多少种埋伏选择。
     * */

    /*Solution
    * 垃圾题目
    * */

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int d=s.nextInt();
        int[] pos=new int[n];
        for(int i=0;i<n;i++){
            pos[i]=s.nextInt();
        }
        long result=0;
        int j=2;
        for(int i=0;i<n;i++){
            while(j<=n-2&&pos[j+1]-pos[i]<=d){
                j++;
            }
            if(j-i<=1&&j<=n-2) {
                j++;
                continue;
            }
            result+=getSum(j-i-1);

        }
        System.out.println(result%99997867);
    }
    private static long getSum(long n){
        if(n<=0)
            return 0;
        return n*(n-1)/2;
    }
}
