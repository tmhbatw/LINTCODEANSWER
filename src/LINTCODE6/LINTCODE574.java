package LINTCODE6;

public class LINTCODE574 {
    /*Description
    * 给出一个二维的网格，每一个格子上用 1 表示房子，0 表示空。要求在网格中，找到一个空地建立邮局，
    * 使得邮局到所有的房子的距离和最小。返回所有房子到邮局的最小距离和，如果不可能建邮局则返回-1。
    * */

    public int shortestDistance(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] row=new int[m];
        int[] col=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int[] dpRow=getDis(row,m);
        int[] dpCol=getDis(col,n);
        int result=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    result=Math.min(result,dpRow[i]+dpCol[j]);
                }
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
        // write your code here
    }

    private int[] getDis(int[] row,int m){
        int[] dpRow=new int[m];
        int preDis=0;
        int preTime=0;
        int lastTime=row[0];
        for(int i=m-1;i>=0;i--) {
            lastTime += row[i];
            preDis +=row[i]*i;
        }
        for(int i=0;i<m;i++){
            dpRow[i]=preDis;
            preTime+=row[i];
            preDis+=preTime;
            lastTime-=row[i];
            preDis-=lastTime;
        }
        return dpRow;
    }
}
