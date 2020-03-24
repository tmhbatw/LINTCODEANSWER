package LINTCODE19;

public class LINTCODE1869 {
    /*Description
    * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
    * */

    public int countSquares(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] dp=new int[row][col];
        int result=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0||j==0)
                    dp[i][j]=matrix[i][j];
                else if(matrix[i][j]==0)
                    dp[i][j]=0;
                else
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j])+1;
                result+=dp[i][j];
            }
        }
        return result;
        // write your code here
    }
}
