package LINTCODE18;

import java.util.HashMap;

public class LINTCODE1712 {
    /*Description
    *在由若干 0 和 1 组成的数组 A 中，有多少个和为 S 的非空子数组。
    * */

    /*Solution
    * 用哈希表保存一下前缀和
    * */

    public int numSubarraysWithSum(int[] A, int S) {
        int result=0;
        int curSum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<A.length;i++){
            curSum+=A[i];
            result+=map.getOrDefault(curSum-S,0);
            map.put(curSum,map.getOrDefault(curSum,0)+1);
            System.out.println(result);
        }
        System.out.println(map);
        return result;
        // Write your code here.
    }
}
