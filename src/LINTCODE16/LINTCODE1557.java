package LINTCODE16;

import java.util.*;

public class LINTCODE1557 {
    /*Description
    *给定一个包含n个正整数的数组a，另外有一个长度为n的价值数组b，表示第i个正整数的价值为b[i]。
    * 我们可以选择任意个不相交区间[i, j]，需要满足i < j 且a[i] = a[j]，
    * 随后我们可以获得区间[i, j]所有数的价值，即b[i] + b[i+1] + ... + b[j]。
    * 现在请输出可以获得的数组最大价值。
    * */

    public int getAnswer(int[] a, int[] b) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<a.length;i++){
            map.putIfAbsent(a[i],new ArrayList<>());
            map.get(a[i]).add(i);
        }
        int[] sum=new int[b.length+1];
        for(int i=0;i<b.length;i++)
            sum[i+1]=sum[i]+b[i];
        int[] dp=new int[b.length+1];
        for(int i=0;i<a.length;i++){
            dp[i+1]=dp[i];
            List<Integer> list=map.get(a[i]);
            for (Integer cur : list) {
                if (cur == i)
                    break;
                dp[i + 1] = Math.max(dp[cur] + sum[i + 1] - sum[cur], dp[i + 1]);
            }

        }
        return dp[a.length];
        // Write your code here
    }

    public static void main(String[] args){
        int[] a= new int[]{4,2,2,1,2,1};
        int[] b = new int[]{1,2,1,2,1,100};
        System.out.println(new LINTCODE1557().getAnswer(a,b));
    }
}
