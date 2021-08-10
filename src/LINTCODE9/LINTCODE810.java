package LINTCODE9;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE810 {
    /*Description
    * 在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
    * 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为
    * t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时
    * 水位必须同时淹没这两个平台。假定你可以瞬间移动无限距离，也就是默认在方
    * 格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
    * 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N−1,N−1)？
    * */

    public int swimInWater(int[][] grid) {
        int l=Math.max(grid[0][0],grid[grid.length-1][grid[0].length-1]),r=Integer.MAX_VALUE;
        while(l<r){
            int mid=l+(r-l)/2;
            if(getRes(grid,mid))
                r=mid;
            else
                l=mid+1;
        }
        return l;
        // Write your code here
    }

    private boolean getRes(int[][] grid, int mid){
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0});
        int row=grid.length,col=grid[0].length;
        boolean[][] reached=new boolean[row][col];
        reached[0][0]=true;
        int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int[] next:nextPos){
                int i=next[0]+cur[0];
                int j=next[1]+cur[1];
                if(i>=0&&i<row&&j>=0&&j<col&&!reached[i][j]&&grid[i][j]<=mid){
                    if(i==row-1&&j==col-1)
                        return true;
                    reached[i][j]=true;
                    q.add(new int[]{i,j});
                }
            }
        }
        return false;
    }
}