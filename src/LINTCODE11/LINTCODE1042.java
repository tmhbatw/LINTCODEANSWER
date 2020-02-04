package LINTCODE11;

public class LINTCODE1042 {
    /*Description
    * “托普利兹矩阵”是指如果从左上角到右下角的同一条主斜线上每个元素都相等的矩阵.
    * 给定一个M x N矩阵，判断是否为“托普利兹矩阵”.
    * */

    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            int temp=matrix[i][0];
            int j=1;
            while(i+j<matrix.length&&j<matrix[0].length){
                if(matrix[i+j][j]!=temp)
                    return false;
                j++;
            }
        }
        for(int i=1;i<matrix[0].length;i++){
            int temp=matrix[0][i];
            int j=1;
            while(j<matrix.length&&i+j<matrix[0].length){
                if(matrix[j][i+j]!=temp)
                    return false;
                j++;
            }
        }
        return true;
        // Write your code here
    }
}
