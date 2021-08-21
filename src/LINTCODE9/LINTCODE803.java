package LINTCODE9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE803 {
    /*Description
    * 你想在一个空旷的土地上盖房子，在最短的距离内到达所有的建筑物。你只能上下左右移动。你得到的是一个二维数组网格的值为0、1或2，其中:
    * 每一个0标记一个空的土地，你可以自由地通过。
    * 每一个1标记一个你不能通过的建筑物。
    * 每一个2标记一个你不能通过的障碍。
    * */

    int m,n;
    int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

    public int shortestDistance(int[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        int[][] dp=new int[m][n];
        int[][] t=new int[m][n];
        int time=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    time++;
                    dfs(grid,dp,t,i,j);
                }
            }
        }
        int result=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(t[i][j]==time){
                    result=Math.min(result,dp[i][j]);
                }
            }
        }
        for(int[] cur:t){
            System.out.println(Arrays.toString(cur));
        }
        System.out.println("time is:"+time);
        return result==Integer.MAX_VALUE?-1:result;
        // write your code here
    }

    private void dfs(int[][] grid, int[][] dp,int[][] time,int i,int j){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        boolean[][] reached=new boolean[m][n];
        int distance=0;
        while(!q.isEmpty()){
            distance++;
            int size=q.size();
            while(size-->0){
                int[] cur=q.poll();
                for(int[] next:nextPos){
                    int ii=cur[0]+next[0];
                    int jj=cur[1]+next[1];
                    if(ii>=0&&ii<m&&jj>=0&&jj<n&&!reached[ii][jj]&&grid[ii][jj]==0){
                        reached[ii][jj]=true;
                        dp[ii][jj]+=distance;
                        time[ii][jj]++;
                        q.add(new int[]{ii,jj});
                    }
                }
            }
        }
    }
}
