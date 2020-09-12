package LINTCODE20;

import java.util.Arrays;

public class LINTCODE1906 {
    /*Description
    *给一个矩阵，找出所有比邻居（上下左右，对角也算，不考虑边界就是8个咯）都严格大的点，返回一个mask矩阵。
    * *
     */


    public int[][] highpoints(int[][] mask) {
        int row=mask.length;
        int col=mask[0].length;
        int[][] result=new int[row][col];
        for(int[] cur:result)
            Arrays.fill(cur,1);
        int[][] nearPos=new int[][]{{-1,0},{0,1},{1,0},{0,-1}, {-1,-1},{1,1}, {1,-1}};
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int cur=mask[i][j];
                for(int[] curPos:nearPos){
                    int ii=i+curPos[0];
                    int jj=j+curPos[1];
                    if(ii>=0&&ii<row&&jj>=0&&jj<col&&cur<=mask[ii][jj]) {
                        result[i][j]=0;
                        break;
                    }
                }
            }
        }
        return result;
        // write your code here
    }
}
