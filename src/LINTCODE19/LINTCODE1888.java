package LINTCODE19;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1888 {
    /*Description
    * 给定m行n列的矩阵，矩阵中0表示空地、-1表示障碍、1表示目标点（多个）。
    * 对于每个空地，标记出应该从该点向哪个方向出发才能以最短的距离到达目标点。
    * 如果向上出发这将该点标记为2，如果向下出发这将该点标记为3，如果向左出发这将该点标记为4，如果向右出发这将该点标记为5。
    * 方向的优先级从大到小为上、下、左、右，即如果从一个点向上或向下出发都能以最短距离到达目标点，则向上出发。
    * 返回完成标记之后的矩阵。
    * */

    public int[][] shortestPath(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] res=new int[m][n];
        int[][] dis=new int[m][n];
        int[][] pos=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    res[i][j]=1;
                    q.add(new int[]{i,j});
                }
            }
        }
        int distance=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                for(int l=0;l<4;l++){
                    int ii=cur[0]+pos[l][0];
                    int jj=cur[1]+pos[l][1];
                    if(ii>=0&&ii<m&&jj>=0&&jj<n&&grid[ii][jj]!=1&&grid[ii][jj]!=-1){
                        if(dis[ii][jj]==0){
                            q.add(new int[]{ii,jj});
                            dis[ii][jj]=distance;
                            res[ii][jj]=l+2;
                        }
                        else if(dis[ii][jj]==distance&&res[ii][jj]>l+2)
                            res[ii][jj]=l+2;
                    }
                }
            }
            distance++;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(res[i][j]==0)
                    res[i][j]=-1;
            }
        }
        return res;
        //
    }
}
