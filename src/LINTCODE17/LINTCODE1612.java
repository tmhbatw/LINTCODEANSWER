package LINTCODE17;

public class LINTCODE1612 {
    /*Description
    * 给定一个二维矩阵，找到从上到下的最小路径。只能向左下，下，右下移动
    * */

    public int smallestPath(int[][] matrix) {
        if(matrix==null||matrix.length==0)
            return 0;
        int row=matrix.length,col=matrix[0].length;
        if(col==1){
            int result=0;
            for(int[] cur:matrix)
                result+=cur[0];
            return result;
        }
        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                if(j==0){
                    matrix[i][j]+=Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                }else if(j==col-1)
                    matrix[i][j]+=Math.min(matrix[i-1][j],matrix[i-1][j-1]);
                else
                    matrix[i][j]+=Math.min(matrix[i-1][j-1],Math.min(matrix[i-1][j],matrix[i-1][j+1]));
            }
        }
        int result=Integer.MAX_VALUE;
        for(int j=0;j<col;j++)
            result=Math.min(result,matrix[row-1][j]);
        return result;
        // Write your code here
    }
}
