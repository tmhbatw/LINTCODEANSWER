package LINTCODE7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE630 {
    /*Description
    * 在一个 n * m 的棋盘中(二维矩阵中 0 表示空 1 表示有障碍物)，骑士的初始位置是 (0, 0) ，他想要达到 (n - 1, m - 1) 这个位置，
    * 骑士只能从左边走到右边。找出骑士到目标位置所需要走的最短路径并返回其长度，如果骑士无法达到则返回 -1.
    * */

    public int shortestPath2(boolean[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        if(row==1&&col==1)
            return 0;
        if(grid[row-1][col-1])
            return -1;
        grid[0][0]=true;
        int[][] near=new int[][]{{1,2},{-1,2},{2,1},{-2,1}};
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0});
        int time=0;
        while(!queue.isEmpty()){
            time++;
            int size=queue.size();
            while(size-->0){
                int[] cur=queue.poll();
                for(int[] curNear:near){
                    int ii=cur[0]+curNear[0];
                    int jj=cur[1]+curNear[1];
                    if(ii==row-1&&jj==col-1)
                        return time;
                    if(ii>=0&&ii<row&&jj>=0&&jj<col&&!grid[ii][jj]){
                        grid[ii][jj]=true;
                        queue.add(new int[]{ii,jj});
                    }
                }
            }
        }
        return -1;
        // write your code here
    }
}
