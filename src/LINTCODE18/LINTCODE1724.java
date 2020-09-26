package LINTCODE18;

public class LINTCODE1724 {
    /*Description
    * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
    * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length 时 C[i] = A[i]，而当 i >= 0 时 C[i+A.length] = C[i]）
    * 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）
    * */

    public int maxSubarraySumCircular(int[] A) {
        //包含两种可能的情况，一种为用到环形数组条件，一种为未用到环形数组条件
        //下为未用到环形数组条件
        int length=A.length;
        int result=-60000;
        int preSum=0;
        int minPreSum=0;
        int maxPreSum=-60000;
        int curMin=60000;
        int sum=0;
        for(int i=0;i<length;i++){
            sum+=A[i];
            preSum+=A[i];
            result=Math.max(result,preSum-minPreSum);
            curMin=Math.min(curMin,preSum-maxPreSum);
            minPreSum=Math.min(minPreSum,preSum);
            maxPreSum=Math.max(maxPreSum,preSum);
        }
        return Math.max(result,sum-curMin);
    }
}
