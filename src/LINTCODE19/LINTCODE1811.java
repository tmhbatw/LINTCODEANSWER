package LINTCODE19;

import java.util.Arrays;

public class LINTCODE1811 {
    /*Description
    * M * N网格，每个网格都有一个数字，代表该网格中的黄金数量。 如果为空，则为0。
    * 找到一条在以下条件下获得最大金币总和的路径：
    * 1.一条路不可以走重复的网格
    * 2.永远不会越过零。
    * */

    int result=0;

    public int FindMaximumGold(int[][] grids) {
        int m=grids.length,n=grids[0].length;
        boolean[][] reached=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grids[i][j]!=0){
                    reached[i][j]=true;
                    getMaxRouteValue(grids,i,j,reached,grids[i][j]);
                    reached[i][j]=false;
                }
            }
        }
        return result;
        // write your code here
    }

    int[][] near=new int[][]{{0,1},{0,-1},{-1,0},{1,0}};

    private void getMaxRouteValue(int[][] grid,int x,int y,boolean[][] reached,int sum){
        result=Math.max(result,sum);
        for(int[] curNear:near){
            int xx=curNear[0]+x;
            int yy=curNear[1]+y;
            if(xx<0||xx>=grid.length||yy<0||yy>=grid[0].length||reached[xx][yy]||grid[xx][yy]==0)
                continue;
            reached[xx][yy]=true;
            getMaxRouteValue(grid,xx,yy,reached,sum+grid[xx][yy]);
            reached[xx][yy]=false;
        }
    }

    public static void main(String[] args){
        int[][] clone=new int[][]{{-1,0},{0,1}};
        int[][] a=clone.clone();
        a[0][0]=0;
        for(int[] cur:a)
            System.out.println(Arrays.toString(cur));
        for(int[] cur:clone)
            System.out.println(Arrays.toString(cur));
    }
}
