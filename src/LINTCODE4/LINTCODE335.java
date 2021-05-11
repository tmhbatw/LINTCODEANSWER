package LINTCODE4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LINTCODE335 {
    /*Description
    * 给定一个n*m的网格。每个格子有一个高度h
    * 定义高原为一组连通且等高的格子，且比所有与连通块相邻的格子高，找出所有高原。
    * 在这个任务中，你将得到一个矩阵表示每个格子的高度。你需要返回一个矩阵，在这个矩阵中1代表高原格子，0代表非高原。
    * */

    public int[][] getPlateau(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] dp=new int[m][n];
        Map<Integer,Integer> map=new HashMap<>();
        int index=1;
        int[][] pos=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]>0)
                    continue;
                map.put(index,1);
                Queue<int[]> q=new LinkedList<>();
                q.add(new int[]{i,j});
                while(!q.isEmpty()){
                    int[] cur=q.poll();
                    if(dp[cur[0]][cur[1]]>0)
                        continue;
                    dp[cur[0]][cur[1]]=index;
                    for(int[] nextPos:pos){
                        int ii=cur[0]+nextPos[0];
                        int jj=cur[1]+nextPos[1];
                        if(ii>=0&&ii<m&&jj>=0&&jj<n){
                            if(grid[ii][jj]>grid[cur[0]][cur[1]]){
                                map.put(index,0);
                            }
                            else if(grid[ii][jj]==grid[cur[0]][cur[1]]){
                                q.add(new int[]{ii,jj});
                            }
                        }
                    }
                }
                index++;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=map.get(dp[i][j]);
            }
        }
        return dp;
        // write your code here
    }
}
