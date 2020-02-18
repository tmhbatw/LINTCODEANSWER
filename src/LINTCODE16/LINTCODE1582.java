package LINTCODE16;

public class LINTCODE1582 {
    /*Description
    * 给出一个 n * m的矩阵，每个点有一个权值，从矩阵左下走到右上(可以走四个方向)，
    * 让你找到一条路径 使得该路径所路过的权值和最小，输出最小权值和。
    * */

    public int minPathSumII(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] dp=new int[row][col];
        dp[row-1][0]=matrix[row-1][0];
        for(int i=1;i<matrix[0].length;i++){
            dp[row-1][i]=dp[row-1][i-1]+matrix[row-1][i];
        }
        for(int j=matrix.length-2;j>=0;j--){
            dp[j][0]=dp[j+1][0]+matrix[j][0];
        }
        for(int i=row-2;i>=0;i--){
            for(int j=1;j<col;j++){
                dp[i][j]=Math.min(dp[i+1][j],dp[i][j-1])+matrix[i][j];
            }
        }
        return matrix[0][col-1];
        // Write your code here
    }
}
