package LINTCODE2;

public class LINTCODE161 {

    /*Description
    * You are given an n x n 2D matrix representing an image.
    * Rotate the image by 90 degrees (clockwise).
    * */

    /*Solution
    *可以先将图向下对折，然后沿着对角线替换位置
    *
    * */
    public void rotate(int[][] matrix) {
        for(int i=0;i<(matrix.length)/2;i++){
            for(int j=0;i<matrix[0].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[matrix.length-1-i][j];
                matrix[matrix.length-1-i][j]=temp;
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
       // write your code here
    }

}
