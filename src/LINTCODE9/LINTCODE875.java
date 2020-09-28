package LINTCODE9;

public class LINTCODE875 {
    /*Description
    * 矩阵中连续的最长的直线
    * 给定一个01矩阵，找出矩阵中连续的最长的 1 。这条线可以是水平的，垂直的，对角线的或者反对角线的。
    * */

    public int longestLine(int[][] M) {
        if(M==null||M.length==0)
            return 0;
        int row=M.length;
        int col=M[0].length;
        int[][][] dp=new int[row+1][col+2][4];
        int result=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(M[i][j]==1){
                    dp[i+1][j+1][0]=dp[i][j+1][0]+1;
                    dp[i+1][j+1][1]=dp[i+1][j][1]+1;
                    dp[i+1][j+1][2]=dp[i][j][2]+1;
                    dp[i+1][j+1][3]=dp[i][j+2][3]+1;
                    result=Math.max(result,Math.max(Math.max(dp[i+1][j+1][0],dp[i+1][j+1][1]),Math.max(dp[i+1][j+1][2],dp[i+1][j+1][3])));
                }
            }
        }
        return result;
        // Write your code here
    }
}
