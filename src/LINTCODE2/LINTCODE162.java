package LINTCODE2;

public class LINTCODE162 {
    /*Description
    * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
    * */

    /*Solution
    * 因为要求不占用额外空间，因此需要找到一行一列来存储这一行是否为0
    * 这一行这一列应该由第一个0出现的位置所决定
    * */

    public void setZeroes(int[][] matrix) {
        if(matrix.length==0)
            return;
        int m=matrix.length,n=matrix[0].length;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    m=i;
                    n=j;
                    break;
                }
            }
            if(m!=matrix.length)
                break;
        }
        for(int i=m;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[m][j]=0;
                    matrix[i][n]=0;
                }
            }
        }
        if(m==matrix.length)
            return;


        for(int i=0;i<matrix.length;i++){
            if(i==m)
                continue;
            for(int j=0;j<matrix[0].length;j++){
                if(j==n)
                    continue;
                if(matrix[m][j]==0||matrix[i][n]==0)
                    matrix[i][j]=0;
            }
        }
        for(int i=0;i<matrix.length;i++){
            matrix[i][n]=0;
        }
        for(int i=0;i<matrix[0].length;i++){
            matrix[m][i]=0;
        }
    }
}
