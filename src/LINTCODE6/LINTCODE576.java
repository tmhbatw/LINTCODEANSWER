package LINTCODE6;

public class LINTCODE576 {
    /*Description
    * 给你一个长度为N的整型数组arr，使用下标从0到N-1，
       请你选出两个数p  q  要求 0 < p < q < N-1  q-p>1，求出arr[p]+arr[q]的最小值
    * */

    public int splitArray(int[] arr) {
        int length=arr.length;
        int[] dp=new int[length];
        dp[length-4]=arr[length-2];
        for(int i=length-5;i>=0;i--){
            dp[i]=Math.min(dp[i+1],arr[i+2]);
        }
        int result=Integer.MAX_VALUE;
        for(int i=1;i<length-3;i++){
            result=Math.min(arr[i]+dp[i],result);
        }
        return result;
        // write your code here
    }
}
