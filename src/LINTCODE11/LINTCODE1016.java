package LINTCODE11;

public class LINTCODE1016 {
    /*Description
    *有两个具有相同非零长度的整数序列A和B。可以交换它们的一些元素A[i]和B[i]。 注意，两个可交换的元素在它们各自的序列中处于相同的索引位置。
    * 进行一些交换之后，A和B需要严格递增。 （当且仅当A[0] < A[1] < A[2] < ... < A[A.length - 1]时，序列严格递增。）
    * 给定A和B，返回使两个序列严格递增的最小交换次数。 保证给定的输入经过交换可以满足递增的条件。
    * */

    public int minSwap(int[] A, int[] B) {
        int length=A.length;
        int[][] dp=new int[length][2];
        //dp[i][0]用来表示第i位不交换位置的最小值，dp[i][1]用来表示第i位交换位置的最小值
        if(A[0]!=B[0])
            dp[0][1]=1;
        for(int i=1;i<length;i++){
            if(A[i]==B[i]){
                dp[i][0]=dp[i][1]=Math.min(dp[i-1][0],dp[i-1][1]);
            }
            if(A[i]>A[i-1]&&B[i]>B[i-1]){
                if(A[i]>B[i-1]&&B[i]>A[i-1]){
                    dp[i][0]=Math.min(dp[i-1][0],dp[i-1][1]);
                    dp[i][1]=Math.min(dp[i-1][0],dp[i-1][1])+1;
                }else {
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = dp[i - 1][1] + 1;
                }
            }
            else{
                dp[i][0]=dp[i-1][1]+1;
                dp[i][1]=dp[i-1][0]+1;
            }
        }
        return Math.min(dp[length-1][0],dp[length-1][1]);
        // Write your code here
    }
}
