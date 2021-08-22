package LINTCODE3;

import java.util.Arrays;

public class LINTCODE269 {
    /*Description
    *
    * */


    public int twoColorsTower(int red, int green) {
        int l=getMax(red+green);
        int mod=1000000007;
        int[] sum=new int[l+1];
        for(int i=1;i<=l;i++)
            sum[i]=sum[i-1]+i;
        System.out.println(Arrays.toString(sum));
        int[] dp=new int[red+1];
        dp[0]=1;
        for(int i=1;i<=l;i++){
            int[] curDp=new int[red+1];
            for(int j=red;j>=0;j--){
                if(sum[i]-j>green)
                    break;
                curDp[j]=dp[j];
            }
            for(int j=0;j<=red-i;j++) {
                curDp[j+i] +=dp[j];
                curDp[j+i]%=mod;
            }
            dp=curDp;
            System.out.println(Arrays.toString(dp));
        }
        int result=0;
        for(int j=0;j<=red;j++){
            result+=dp[j];
            result%=mod;
        }
        return result;
        // write your code here
    }

    private int getMax(int sum){
        int l=1,r=500;
        while(l<r){
            int mid=(l+r)/2;
            if(mid*(mid+1)/2>sum)
                r=mid-1;
            else
                l=mid;
        }
        return l;
    }

    public static void main(String[] args){
        System.out.println(new LINTCODE269().twoColorsTower(4,6));
    }
}
