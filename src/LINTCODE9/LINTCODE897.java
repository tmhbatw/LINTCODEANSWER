package LINTCODE9;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE897 {
    /*Description
    * 给一个n x m的矩阵，矩阵的值有0、1、2，0代表海，1代表海岛，2代表海岛上的城市（你可以看做2是建立在1的上面，即2也也同时代表海岛）。
    * 如果2个1相邻，那么这两个1属于同一个岛。现在求至少有一个城市的海岛个数。
    * */

    public int numIslandCities(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int result=0;
        int[][] near=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0)
                    continue;
                Queue<int[]> queue=new LinkedList<>();
                queue.add(new int[]{i,j});
                boolean hasCity=false;
                while(!queue.isEmpty()){
                    int[] cur=queue.poll();
                    if(grid[cur[0]][cur[1]]==2)
                        hasCity=true;
                    grid[cur[0]][cur[1]]=0;
                    for(int[] curNear:near){
                        int ii=cur[0]+curNear[0];
                        int jj=cur[1]+curNear[1];
                        if(ii>=0&&ii<row&&jj>=0&&jj<col&&grid[ii][jj]!=0)
                            queue.add(new int[]{ii,jj});
                    }
                }
                if(hasCity)
                    result++;
            }
        }
        return result;
        // Write your code here
    }
}
