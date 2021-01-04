package LINTCODE10;

public class LINTCODE937 {
    /*Description
    * 给定一个正整数n，表示一场比赛的时间，比赛中题目的难度是递增的，你每完成一个题目，就要花费k × i的时间，
    * 其中k是输入的一个系数，i表示题目的序号(从1开始)。根据这些信息，返回这场比赛中，你最多能完成几个题目。
     * */

    public long canAccept(long n, int k) {
        n/=k;
        n*=2;
        long left=0,right=2147483647;
        while(left<=right){
            long mid=left+(right-left)/2;
            if(mid*(mid+1)>mid)
                right=mid-1;
            else if((mid+1)*(mid+2)>mid)
                return mid;
            else
                left=mid+1;
        }
        return left;
        // Write your code here
    }

    public static void main(String[] args){
        long result=Long.MAX_VALUE/4;
        long res=Integer.MAX_VALUE;
        System.out.println(res*(res+1));
        System.out.println(result/4);
        System.out.println(Math.pow(2,61)-1);
    }
}
