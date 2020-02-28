package LINTCODE13;

public class LINTCODE1205 {
    /*Description
    *给定M×N个元素的矩阵（M行，N列），以对角线顺序返回矩阵的所有元素，如下例所示。
    * */

    public int[] findDiagonalOrder(int[][] matrix) {
        int row=matrix.length;
        if(row==0)
            return new int[]{};
        int col=matrix[0].length;
        int[] result=new int[row*col];
        int index=0;
        boolean flag=false;
        int i=0;
        int j=0;
        while(index!=row*col){
            result[index]=matrix[i][j];
            if(flag){
                while(i<row-1&&j>=1){
                    i++;
                    j--;
                    result[++index]=matrix[i][j];
                }
                if(i<row-1)
                    i++;
                else
                    j++;
            }else{
                while(i>=1&&j<col-1){
                    i--;
                    j++;
                    result[++index]=matrix[i][j];
                }
                if(j<col-1)
                    j++;
                else
                    i++;
            }
            flag=!flag;
            index++;
        }
        return result;
        // write your code here
    }
}
