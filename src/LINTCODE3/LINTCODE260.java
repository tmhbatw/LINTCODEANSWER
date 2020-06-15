package LINTCODE3;

public class LINTCODE260 {
    /*Description
    *给定一个 n * n 的矩阵，如果每一条从左上到右下的斜线上的数值相同，返回 true， 否则返回false。
    * */

    public boolean judgeSame(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            int cur=matrix[0][i];
            for(int j=1;j<n-i;j++)
                if(matrix[j][i+j]!=cur)
                    return false;
        }
        for(int j=1;j<n;j++){
            int cur=matrix[j][0];
            for(int i=1;i<n-j;i++){
                if(matrix[j+i][i]!=cur)
                    return false;
            }
        }
        return true;
        // write your code here.
    }
}
