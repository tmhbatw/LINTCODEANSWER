package LINTCODE9;

public class LINTCODE817 {
    /*Description
    * 给定一个二维数组(矩阵), 需要查询它的某个子矩阵的元素的和, 同时矩阵内的元素可以被改变.
    * 你需要实现三个方法:
    * NumMatrix(matrix) 类的构造方法
    * sumRegion(row1, col1, row2, col2) 返回处于 (row1, col1) 为左上角, (row2, col2) 为右下角的子矩阵内的元素的和
    * update(row, col, val) 把 (row, col) 位置的元素更新为 val
    * */

    class NumMatrix {
        int[][] matrix;
        int[][] dp;

        public NumMatrix(int[][] matrix) {
            this.matrix=matrix;
            int row=matrix.length;
            int col=matrix[0].length;
            this.dp=new int[row][col+1];
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    dp[i][j+1]=dp[i][j]+matrix[i][j];
                }
            }
        }

        public void update(int row, int col, int val) {
            matrix[row][col]=val;
            for(int j=col;j<dp[row].length-1;j++){
                dp[row][j+1]=dp[row][j]+matrix[row][j];
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int result=0;
            for(int i=row1;i<=row2;i++)
                result+=dp[i][col2+1]-dp[i][col1];
            return result;
        }
    }
}
