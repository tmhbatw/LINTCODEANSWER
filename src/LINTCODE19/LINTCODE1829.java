package LINTCODE19;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1829 {
    /*Description
    * 给定一张n行m列的地图，其中0代表可以走的路，1代表墙壁，
    * 你可以从第一行的任意位置出发，到最后一行的任意位置。你需要求出最短路的条数。
    * 当两个路径中有任意一步不一样时，我们就称作不同的路径。
    * */


    public int theNumberofShortestPath(int n, int m, int[][] labyrinth) {
        int[][] dp=new int[n][m];
        int[][] time=new int[n][m];
        Queue<int[]> q=new LinkedList<>();
        for(int j=0;j<m;j++){
            if(labyrinth[n-1][j]==0){
                dp[n-1][j]=1;
                time[n-1][j]=1;
                q.add(new int[]{n-1,j});
            }
        }
        int[][] pos=new int[][]{{-1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                for(int[] nextPos:pos){
                    int ii=cur[0]+nextPos[0];
                    int jj=cur[1]+nextPos[1];
                    if(ii>=0&&jj>=0&&jj<m&&labyrinth[ii][jj]==0&&(dp[ii][jj]==0||dp[ii][jj]==dp[cur[0]][cur[1]]+1)){
                        if(dp[ii][jj]==0)
                            q.add(new int[]{ii,jj});
                        time[ii][jj]+=time[cur[0]][cur[1]];
                        dp[ii][jj]=dp[cur[0]][cur[1]]+1;
                    }
                }
            }
        }
        int min=Integer.MAX_VALUE;
        int count=0;
        for(int j=0;j<m;j++){
            if(dp[0][j]!=0&&dp[0][j]<min){
                min=dp[0][j];
                count=0;
            }
            if(dp[0][j]==min){
                count+=time[0][j];
            }
        }
        for(int[] cur:dp){
            System.out.println(Arrays.toString(cur));
        }
        for(int[] cur:time){
            System.out.println(Arrays.toString(cur));
        }
        return count;
        // write your code here
    }
}
