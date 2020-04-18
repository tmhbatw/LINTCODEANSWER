package LINTCODE18;

public class LINTCODE1727 {
    /*Description
    * 给定一个数组 A，将其划分为两个不相交（没有公共元素）的连续子数组 left 和 right， 使得：
    * left 中的每个元素都小于或等于 right 中的每个元素。
    * left 和 right 都是非空的。
    * left 要尽可能小。
    * 在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
    * */

    public int partitionDisjoint(int[] A) {
        int length=A.length;
        int[] dp=new int[length];
        dp[length-1]=A[length-1];
        for(int j=length-2;j>=0;j--){
            dp[j]=Math.min(A[j],dp[j+1]);
        }
        int preMax=Integer.MIN_VALUE;
        for(int i=0;i<length-1;i++){
            preMax=Math.max(preMax,A[i]);
            if(preMax<=dp[i+1])
                return i+1;
        }
        return -1;
        // write your code here
    }
}
