package LINTCODE17;

public class LINTCODE1621 {
    /*Description
    * 给定一个0和1的矩阵, 第一行是roof.
    * 移出一个 '1'之后, 同一列没有连接到roof的'1' 都会掉落，并且变为 '0'.
    * */

    public int[][] removeOne(int[][] matrix, int x, int y) {
        matrix[x][y]=0;
        while(x<matrix.length-1&&matrix[x+1][y]==1)
            matrix[++x][y]=0;
        return matrix;
        // Write your code here
    }
}
