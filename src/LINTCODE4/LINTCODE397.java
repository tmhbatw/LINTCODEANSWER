package LINTCODE4;

public class LINTCODE397 {
    /*Descrtiption
    * 给定一个整数数组（下标从 0 到 n-1， n 表示整个数组的规模），请找出该数组中的最长上升连续子序列。
    * （最长上升连续子序列可以定义为从右到左或从左到右的序列。）
    * */

    public int longestIncreasingContinuousSubsequence(int[] A) {
        if(A.length<=2)
            return A.length;
        int currLength=2,maxLength=2;
        boolean flag=A[1]>A[0];
        for(int i=2;i<A.length;i++){
            if(A[i]>A[i-1]&&flag||A[i]<A[i-1]&&!flag){
                currLength++;
                maxLength=Math.max(currLength,maxLength);
            }else{
                currLength=2;
                flag=A[i]>A[i-1];
            }
        }
        return maxLength;
        // write your code here
    }
}
