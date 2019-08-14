package LINTCODE8;

public class LINTCODE770 {
    /*Description
    *给定一个矩阵，返回矩阵中的最大数和最小数
    * */

    public int[] maxAndMin(int[][] matrix) {
        if(matrix.length==0)
            return new int[]{};
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                max=Math.max(max,matrix[i][j]);
                min=Math.min(min,matrix[i][j]);
            }
        }
        return new int[]{max,min};
        // write your code here
    }
}
