package LINTCODE4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE388 {
    /*Description
    * Given n and k, find the kth permutation of the dictionary order in the full permutation of n.
    * */

    /*Solution
    * 可以使用一个数组用来保存当某一位确定后，剩下的数字排列情况有多少种情况
    * */


    public String getPermutation(int n, int k) {
        if(n==0||k==0)
            return null;
        int[] dp=new int[n];
        dp[n-1]=1;
        int index=1;
        for(int i=n-2;i>=0;i--){
            dp[i]=dp[i+1]*index++;
        }
        System.out.println(Arrays.toString(dp));
        List<Integer> numbers=new ArrayList<>();
        for(int i=1;i<=n;i++){
            numbers.add(i);
        }
        String result="";
        for(int i=0;i<dp.length;i++){
            int count=0;
            while(k>dp[i]){
                count++;
                k-=dp[i];
            }
            result+=numbers.get(i);
            numbers.remove(i);
        }
        return result;
        // write your code here
    }

    public static void main(String[] args){
        int result=1;
        for(int i=1;i<=8;i++)
            result*=i;
        System.out.println(result);
    }
}
