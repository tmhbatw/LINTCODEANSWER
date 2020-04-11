package LINTCODE7;

import datastructure.Point;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE611 {
    /*Description
    *给定骑士在棋盘上的 初始 位置(一个2进制矩阵 0 表示空 1 表示有障碍物)，找到到达 终点 的最短路线，返回路线的长度。如果骑士不能到达则返回 -1 。
    * */


    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if(destination.x==source.x&&destination.y==source.y)
            return 0;
        if(grid[destination.x][destination.y])
            return -1;
        int row=grid.length;
        int col=grid[0].length;
        int[][] near=new int[][]{{1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}};
        grid[source.x][source.y]=true;
        Queue<Point> queue=new LinkedList<>();
        queue.add(source);
        int time=0;
        while(!queue.isEmpty()){
            time++;
            int size=queue.size();
            while(size-->0){
                Point cur=queue.poll();
                for(int[] curNear:near){
                    int ii=cur.x+curNear[0];
                    int jj=cur.y+curNear[1];
                    if(ii==destination.x&&jj==destination.y)
                        return time;
                    if(ii>=0&&ii<row&&jj>=0&&jj<col&&!grid[ii][jj]){
                        queue.add(new Point(ii,jj));
                        grid[ii][jj]=true;
                    }
                }
            }
        }
        return -1;
        // write your code here
    }
}
