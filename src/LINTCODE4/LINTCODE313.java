package LINTCODE4;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE313 {
    /*Description
    *有两个数组 a 和 b，两个数组都由相同的整型数字集合组成，且每个数组中无重复。
    * 每次操作可以将 a 的第一个或最后一个数字插入到 a 的任何位置中.
    * 问最少操作几次，可以将 a 变换成 b。
    * */

    public int minimumInsertion(int[] a, int[] b) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<b.length;i++)
            map.put(b[i],i);
        for(int i=0;i<a.length;i++){
            a[i]=map.get(a[i]);
        }
        int result=1;
        int[] dp=new int[a.length];
        dp[0]=1;
        for(int i=1;i<a.length;i++){
            if(a[i]>a[i-1]) {
                dp[i] = dp[i - 1] + 1;
                result=Math.max(result,dp[i]);
            }
            else
                dp[i]=1;
        }
        return a.length-result;
        // write your code here.
    }
}
