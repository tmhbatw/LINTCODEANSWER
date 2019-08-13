package LINTCODE7;

import java.util.Arrays;

public class LINTCODE665 {
    /*Description
    * 给一 二维矩阵,计算由左上角 (row1, col1) 和右下角 (row2, col2) 划定的矩形内元素和.
    * */

    /*Solution
    * 在初始化的时候可以记录面积
    * */


    class NumMatrix {

        int[][] curMatrix;

        public NumMatrix(int[][] matrix) {
            this.curMatrix=new int[matrix.length+1][matrix[0].length+1];
            for(int i=0;i<curMatrix.length;i++){
                int rowSum=0;
                for(int j=0;j<curMatrix[0].length;j++){
                    rowSum+=matrix[i][j];
                    curMatrix[i+1][j+1]=rowSum+curMatrix[i][j+1];
                }
            }
            for(int[] cur:curMatrix)
                System.out.println(Arrays.toString(cur));
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return curMatrix[row2+1][col2+1]+curMatrix[row1][col1]-curMatrix[row2+1][col1]-curMatrix[row1][col2+1];
        }
    }
}
