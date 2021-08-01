package LINTCODE15;

import java.util.Arrays;

public class LINTCODE1464 {
    /*Description
    * 有 n 个人，他们的编号分别为 1,2,3,...,n，n 为偶数。选择其中的一半人有 C(n, n/2) 种组合方式，
    * 每一种组合方式按照编号从小到大排序，再将已排序的组合方式按照字典序排序，求第 k 种组合方式。
    * */

    public int[] getCombination(int n, int k) {
        long[][] dp=getC(n);
        int[] res=new int[n/2];
        int cur=1;
        for(int i=0;i<n/2;i++){
            long next=dp[n-cur][n/2-i-1];
            while(k>next){
                k-=next;
                cur++;
                next=dp[n-cur][n/2-i-1];
            }
            res[i]=cur++;
        }
        return res;
        // Write your code here
    }

    private long[][] getC(int n){
        long[][] dp=new long[n+1][n/2+1];
        for(int i=0;i<=n/2;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j =0;j<=Math.min(n/2,i);j++){
                if(j==0||j==i){
                    dp[i][j]=1;
                }else {
                    dp[i][j] = dp[i][j-1] * (i-j+1)/(j);
                }
            }
        }
        return dp;
    }

    public static void main(String[] args){
        long[][] dp=new LINTCODE1464().getC(6);
        for(long[] cur:dp){
            System.out.println(Arrays.toString(cur));
        }

    }
}
