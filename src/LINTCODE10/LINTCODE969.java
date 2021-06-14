package LINTCODE10;

import java.util.HashMap;
import java.util.Map;

public class LINTCODE969 {
    /*Description
    * 给出一个字符串str，找到最长重复不小于k次的子串，输出长度，子串可以有重叠部分，但不能完全重叠。
    * */

    public int longestRepeatingSubsequenceII(String str, int k) {
        int l=str.length();
        long seed=33;
        long mod=100000000007L;
        Map<Long,Integer> map=new HashMap<>();
        int result=0;
        for(int i=0;i<l;i++){
            long count=0;
            for(int j=i;j<l;j++){
                count=(seed*count+str.charAt(j))%mod;
                map.put(count,map.getOrDefault(count,0)+1);
                if(map.get(count)>=k)
                    result=Math.max(result,j-i+1);
            }
        }
        return result;
        // Write your code here
    }
}
