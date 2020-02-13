package LINTCODE18;

public class LINTCODE1711 {
    /*Description
    * 给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
    * 下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
    * */

        public int minFallingPathSum(int[][] A) {
            if(A.length==1)
                return A[0][0];
            int length=A.length;
            int[][] dp=new int[length][length];
            for(int i=0;i<length;i++)
                dp[0][i]=A[0][i];
            for(int i=1;i<length;i++){
                for(int j=0;j<length;j++){
                    int cur1=j>=1?dp[i-1][j-1]:Integer.MAX_VALUE;
                    int cur2=dp[i-1][j];
                    int cur3=j<length-1?dp[i-1][j+1]:Integer.MAX_VALUE;
                    dp[i][j]=Math.min(Math.min(cur1,cur2),cur3)+A[i][j];
                }
            }
            int min=Integer.MAX_VALUE;
            for(int i=0;i<length;i++)
                min=Math.min(min,dp[length-1][i]);
            return min;
            // Write your code here
        }
}
