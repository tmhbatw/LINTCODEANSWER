package LINTCODE6;

public class LINTCODE567 {
    /*Description
    * 给定一个矩阵matrix，matrix[i][j]表示你到达第i行第j列可以得到的分数，现在你要用第0行任意一点出发，
    * 从每行里找到一个点进行跳跃，每次从(i, j)到(i + 1, k)跳跃需要消耗∣j−k∣的分数，请问到最后一行以后，你最多可以得到多少分。
    * */


    public int maximumScore(int[][] matrix) {
        int row=matrix.length,col=matrix[0].length;
        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                int cur=0;
                for(int k=0;k<col;k++){
                    cur=Math.max(cur,matrix[i-1][k]-Math.abs(k-j));
                }
                matrix[i][j]+=cur;
            }
        }
        int result=0;
        for(int j=0;j<col;j++){
            result=Math.max(result,matrix[row-1][j]);
        }
        return result;
        // write your code here
    }

}
