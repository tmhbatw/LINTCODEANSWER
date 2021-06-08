package LINTCODE16;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LINTCODE1584 {
    /*Description
    * 给定整数n,m以及一维数组arr，从数组arr中取若干元素求异或和，共能得到2^n个结果(n为arr的大小)，
    * 请求出这些结果中大于m的有多少个，输出结果对1000000007取模。
    * */

    public int getAns(int n, int m, int[] arr) {
        int[] dp=new int[1024];
        dp[0]=1;
        arr=removeDup(arr);
        Arrays.sort(arr);
        int mod=1000000009;
        for (int cur : arr) {
            int[] curDp = new int[1024];
            for (int j = 0; j < 1024; j++) {
                curDp[j] = (dp[j] + dp[j ^ cur]) % mod;
            }
            dp = curDp;
        }
        int result=0;
        for(int j=m+1;j<1024;j++)
            result=(result+dp[j])%mod;
        return result;
        // Write your code here
    }

    private int[] removeDup(int[] arr){
        Set<Integer> set=new HashSet<>();
        for(int cur:arr)
            set.add(cur);
        int[] result=new int[set.size()];
        int index=0;
        for(int cur:set)
            result[index++]=cur;
        return result;
    }

    public static void main(String[] args){
        int a = 2;
        int b = 3;
        System.out.println(2^1);
    }
}
