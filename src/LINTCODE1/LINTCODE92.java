package LINTCODE1;

import java.util.Arrays;
import java.util.Collections;

public class LINTCODE92 {
    /*Description
    * 在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]
    * */

    /*Solution
    * 简单的动态规划问题
    * 首先将数组排序（塞入数字时应当从大到小塞方能赛更多的东西，常识）
    * dp[i]用来表示第i个数字时能塞入背包的最大数
    * dp[i]等于前i-1个拥有最小的且能容纳A[i]的空间减去A[i];
    * */

    public int backPack(int m, int[] A) {
        Arrays.sort(A);
        change(A);
        int[] dp=new int[A.length+1];
        dp[0]=m;
        int result=m;
        for(int i=1;i<A.length+1;i++){
            int last=m;
            for(int j=0;j<=i-1;j++){
                if(dp[j]>=A[i-1]){
                    last=Math.min(last,dp[j]);
                }
            }
            dp[i]=last>A[i-1]?last-A[i-1]:m;
            result=Math.min(dp[i],result);
        }
        System.out.println(Arrays.toString(dp));
        return m-result;
        // write your code here
    }

    private void change(int[] num){
        int left=0,right=num.length-1;
        while(left<right){
            int temp=num[left];
            num[left]=num[right];
            num[right]=temp;
            left++;
            right--;
        }
    }
}
