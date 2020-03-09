package LINTCODE16;

public class LINTCODE1590 {
    /*Description
    * 在N * N网格上，我们放置一些1 * 1 * 1的立方体。
    * 每个值v = grid [i] [j]表示放置在网格单元（i，j）处放了v个立方体
    * 返回整个网格上立方体的总表面积。
    * */

    public int surfaceAreaof3DShapes(int[][] grid) {
        int result=0;
        int row=grid.length;
        int col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]!=0)
                    result+=grid[i][j]*4+2;
            }
        }
        for(int i=0;i<row;i++){
            for(int j=1;j<col;j++)
                result-=Math.min(grid[i][j],grid[i][j-1])*2;
        }
        for(int j=0;j<col;j++){
            for(int i=1;i<row;i++)
                result-=Math.min(grid[i-1][j],grid[i][j])*2;
        }
        return result;
        // Write your code here.
    }
}
