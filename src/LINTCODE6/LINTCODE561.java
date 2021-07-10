package LINTCODE6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LINTCODE561 {
    /*Description
    * 定义两个等长数组的距离为它们各项相同下标的差值绝对值之和。
    * 比如，A[]=[5,4,3,7,8],B[]=[3,4,2,1,9] ,那么A[]和B[]的距离为|5-3|+|4-4|+|3-2|+|7-1|+|8-9|=10。
    * 在这个问题中，给出一个数组A[]，你需要找到一个等长的不递减数组B[]，使得A[]和B[]的距离值最小。
    * 你只需返回最小的距离值。
    * */

    /*Solution
    * b数组中的数字一定是a数组中的数字
    * */
    public long arrayDistance(int[] A) {
        if(A.length==0)
            return 0;
        Set<Integer> set=new HashSet<>();
        for(int cur:A)
            set.add(cur);
        int size=set.size();
        int[] num=new int[size];
        int index=0;
        for(int cur:set){
            num[index++]=cur;
        }
        Arrays.sort(num);
        int length=A.length;
        long[][] dp=new long[length+1][size];
        for(int i=0;i<length;i++){
            long min=Long.MAX_VALUE;
            for(int j=0;j<size;j++){
                dp[i+1][j] = Math.min(min,dp[i][j]) +Math.abs(A[i]-num[j]);
                min=Math.min(min,dp[i][j]);
            }
        }
        long res = Long.MAX_VALUE;
        for(int j=0;j<size;j++){
            res=Math.min(res,dp[length][j]);
        }
        return res;
        // write your code here
    }
}
