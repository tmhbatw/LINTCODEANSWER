package LINTCODE9;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE860 {
    /*Description
    * 给定一个由0和1组成的非空的二维网格，一个岛屿是指四个方向（包括横向和纵向）都相连的一组1（1表示陆地）。
    * 你可以假设网格的四个边缘都被水包围。找出所有不同的岛屿的个数。如果一个岛屿与另一个岛屿形状相同（不考虑旋转和翻折），
    * 我们认为这两个岛屿是相同的。
    * */

    boolean[][] reached;
    int m;
    int n;
    int[][] next=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    int[][] grid;
    public int numberofDistinctIslands(int[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        this.reached=new boolean[m][n];
        this.grid=grid;
        Set<String> set=new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!reached[i][j]&&grid[i][j]==1){
                    StringBuilder sb=new StringBuilder();
                    reached[i][j]=true;
                    dfs(i,j,sb,i,j);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
        // write your code here
    }

    private void dfs(int i,int j,StringBuilder sb,int fI,int fJ){
        sb.append(i-fI).append(",").append(j-fJ).append(",");
        sb.append(" ");
        for(int[] nextPos:next){
            int ii=nextPos[0]+i;
            int jj=nextPos[1]+j;
            if(ii>=0&&ii<m&&jj>=0&&jj<n&&!reached[ii][jj]&&grid[ii][jj]==1){
                reached[ii][jj]=true;
                dfs(ii,jj,sb,fI,fJ);
                sb.append(" ");
            }
        }
    }
}
