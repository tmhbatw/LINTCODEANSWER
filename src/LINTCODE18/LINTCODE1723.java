package LINTCODE18;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LINTCODE1723 {
    /*Description
    * 给你一个 m * n 的网格，其中每个单元格不是 0（空）就是 1（障碍物）。每一步，您都可以在空白单元格中上、下、左、右移动。
    * 如果您最多可以消除 k 个障碍物，请找出从左上角 (0, 0) 到右下角 (m-1, n-1) 的最短路径，
    * 并返回通过该路径所需的步数。如果找不到这样的路径，则返回 -1。
    * */


    int[][] reached;
    int[][] next=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    int result=Integer.MAX_VALUE;
    public int shortestPath(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        this.reached=new int[m][n];
        for(int[] cur:reached)
            Arrays.fill(cur,-1);
        reached[0][0]=k;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0,k});
        int step=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                if(cur[0]==m-1&&cur[1]==n-1)
                    return step;
                for(int[] nextPos:next){
                    int ii=cur[0]+nextPos[0];
                    int jj=cur[1]+nextPos[1];
                    if(ii>=0&&ii<m&&jj>=0&&jj<n){
                        if(grid[ii][jj]==1){
                            if(cur[2]>0&&cur[2]-1>reached[ii][jj]) {
                                q.add(new int[]{ii, jj, cur[2] - 1});
                                reached[ii][jj]=cur[2]-1;
                            }
                        }else{
                            if(cur[2]>reached[ii][jj]){
                                q.add(new int[]{ii,jj,cur[2]});
                                reached[ii][jj]=cur[2];
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
        // write your code here
    }



}
