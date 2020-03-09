package LINTCODE17;

import java.util.Arrays;

public class LINTCODE1617 {
    /*Description
    *给定一个数组a，输出a[j] - a[i]的最大值，其中i<j, a[i]<a[j], a[i]为奇数，a[j]为偶数
    * */

    public int getAnswer(int[] a) {
        int[] dp=new int[a.length];
        int index=-1;
        for(int i=0;i<a.length;i++){
            if(a[i]%2==1){
                if(index==-1){
                    index=i;
                    dp[i]=a[i];
                }else{
                    dp[i]=Math.min(dp[i],dp[i-1]);
                }
            }else
                dp[i]=i>0?dp[i-1]:0;
        }
        System.out.println(Arrays.toString(dp));
        int result=0;
        for(int i=index+1;i<a.length;i++){
            if(a[i]%2==0)
                result=Math.max(result,a[i]-dp[i]);
        }
        return result;
        // Write your code here
    }
}
