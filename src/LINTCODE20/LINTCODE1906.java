package LINTCODE20;

public class LINTCODE1906 {
    /*Description
    *给一个矩阵，找出所有比邻居（上下左右，对角也算，不考虑边界就是8个咯）都严格大的点，返回一个mask矩阵。
    * *
     */


    public int[][] highpoints(int[][] mask) {
        int row=mask.length;
        int col=mask[0].length;
        int[][] result=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int cur=mask[i][j];
                if(i>=1&&j>=1&&mask[i-1][j-1]>cur)
                    continue;
                if(i>=1&&mask[i-1][j]>cur)
                    continue;
                if(i>=1&&j<col-1&&mask[i-1][j+1]>cur)
                    continue;
                if(j>=1&&mask[i][j-1]>cur)
                    continue;
                if(j<col-1&&mask[i][j+1]>cur)
                    continue;
                if(i<row-1&&j>=1&&mask[i+1][j-1]>cur)
                    continue;
                if(i<row-1&&mask[i+1][j]>cur)
                    continue;
                if(i<row-1&&j<col-1&&mask[i+1][j+1]>cur)
                    continue;
                result[i][j]=1;
            }
        }
        return result;
        // write your code here
    }
}
