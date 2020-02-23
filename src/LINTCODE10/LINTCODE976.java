package LINTCODE10;

import java.util.HashMap;

public class LINTCODE976 {
    /*Description
    * 给出 A, B, C, D 四个整数列表，计算有多少的tuple (i, j, k, l)满足A[i] + B[j] + C[k] + D[l]为 0。
    * 为了简化问题，A, B, C, D 具有相同的长度，且长度N满足 0 ≤ N ≤ 500。所有的整数都在范围(-2^28, 2^28 - 1)内以及保证结果最多为2^31 - 1。
    * */

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<A.length;i++){
            int cur=A[i];
            for(int j=0;j<B.length;j++){
                int curSum=cur+B[j];
                map.put(curSum,map.getOrDefault(curSum,0)+1);
            }
        }
        int result=0;
        for(int i=0;i<C.length;i++){
            int cur=C[i];
            for(int j=0;j<D.length;j++){
                int curSum=cur+D[j];
                result+=map.getOrDefault(-curSum,0);
            }
        }
        return result;
        // Write your code here
    }
}
