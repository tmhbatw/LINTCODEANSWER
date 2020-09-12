package LINTCODE3;

public class LINTCODE293 {
    /*Description
    * 当一个二进制矩阵除了从左上角到右上角的一条路径上值为1，其他值均为0时，我们称这个矩阵有一条隧道。
    * 除了起点和终点只有一个相邻的”1“，在这条路径上的每一个“1"都恰好有两个相邻的”1“。
    * 现在给你一个有隧道的矩阵，请回答这条隧道的深度（这条隧道能到达的最后一行的序号,从0开始计数）
    * */

    public int FindDepth(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        for(int i=row-1;i>=0;i--){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==1)
                    return i;
            }
        }
        return 0;
        //
    }
}
