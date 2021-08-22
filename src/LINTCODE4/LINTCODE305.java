package LINTCODE4;

public class LINTCODE305 {
    /*Description
    * 给出一个矩阵，矩阵内的元素都是整数。
    * 你需要找出矩阵中的一条最长的递增路径，并返回它的长度。
    * 路径可以以矩阵中任何一个坐标作为起点，每次向上、下、左、右四个方向移动，并保证移动路线上的数字递增。
    * 你不可以走出这个矩阵。
    * */

    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp=new int[matrix.length][matrix[0].length];
        int result=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                result=Math.max(result,dfs(matrix,dp,i,j));
            }
        }
        return result;
        // Write your code here.
    }

    int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

    private int dfs(int[][] matrix, int[][] dp, int i, int j){
        if(dp[i][j]>0)
            return dp[i][j];
        dp[i][j]=1;
        for(int[] next:nextPos){
            int ii=next[0]+i;
            int jj=next[1]+j;
            if(ii>=0&&ii<matrix.length&&jj>=0&&jj<matrix[0].length&&matrix[i][j]>matrix[ii][jj]){
                dp[i][j]=Math.max(dp[i][j],dfs(matrix,dp,ii,jj)+1);
            }
        }
        return dp[i][j];
    }

}
