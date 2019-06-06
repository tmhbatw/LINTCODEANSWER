package LINTCODE2;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE198 {
    /*Description
    * Given a permutation which may contain repeated numbers, find its index in all the permutations of these numbers,
    *  which are ordered in lexicographical order. The index begins at 1.
    * */

    /*Solution
    * 与上一题思路基本相同，只不过要去除重复的情况
    * 用一个map对象存储包含当前数字的后面数字每一个数有几个，除去几的阶乘即可
    * */
    public long permutationIndexII(int[] A) {
        Long[] dp=new Long[A.length];
        dp[dp.length-1]= Long.valueOf(1);
        for(int i=1;i<dp.length;i++){
            dp[dp.length-1-i]=dp[dp.length-i]*i;
        }
        Long res=0l;
        for(int i=0;i<A.length;i++){
            int count=0;
            Map<Integer,Integer> map=new HashMap<>();
            map.put(A[i],1);
            for(int j=i+1;j<A.length;j++){
                if(A[j]<A[i])
                    count++;
                if(map.containsKey(A[j])){
                    map.put(A[j],map.get(A[j])+1);
                }else{
                    map.put(A[j],1);
                }
            }
            Long delete=1l;
            for(Map.Entry entry:map.entrySet()){
                delete*=delete((Integer) entry.getValue());
            }
            res+=(count*dp[i]/delete);
        }
        return res+1;
        // write your code here
        // write your code here
    }

    private long delete(int n){
        long res=1;
        for(int i=0;i<n;i++){
            res*=(i+1);
        }
        return res;

    }
        // write your code here
}
