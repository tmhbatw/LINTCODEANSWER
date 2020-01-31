package LINTCODE12;

public class LINTCODE1170 {
    /*Description
    * 在MATLAB中，有一个非常有用的函数叫做'reshape'，它可以将矩阵重新整形为一个不同大小的矩阵，但保留其原始数据。
    * 先给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示所需重新整形矩阵的行数和列数。
    * 重新形成的矩阵需要用原始矩阵的所有元素以相同的行遍历顺序填充。
    * 如果使用给定参数的“重塑”操作是可能且合法的，则输出新的重新整形矩阵; 否则，输出原始矩阵。
    * */

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m=nums.length;
        int n=nums[0].length;
        if(m*n!=r*c)
            return nums;
        int[][] result=new int[r][c];
        int row=0;
        int col=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result[row][col++]=nums[i][j];
                if(col==c){
                    row++;
                    col=0;
                }
            }
        }
        return result;
        // write your code here
    }



}
