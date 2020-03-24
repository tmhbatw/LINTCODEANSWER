package LINTCODE6;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE598 {
    /*Description
    *给一个二维网格，每一个格子都有一个值，2 代表墙，1 代表僵尸，0 代表人类(数字 0, 1, 2)。
    * 僵尸每天可以将上下左右最接近的人类感染成僵尸，但不能穿墙。将所有人类感染为僵尸需要多久，如果不能感染所有人则返回 -1。
    * */

    public int zombie(int[][] grid) {
        int peopleNumber=0;
        Queue<int[]> queue=new LinkedList<>();
        int row=grid.length;
        int col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0)
                    peopleNumber++;
                if(grid[i][j]==1)
                    queue.add(new int[]{i,j});
            }
        }
        if(peopleNumber==0)
            return 0;
        int time=-1;
        int[][] near=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            time++;
            int size=queue.size();
            while(size-->0){
                int[] cur=queue.poll();
                for(int[] curNear:near){
                    int ii=cur[0]+curNear[0];
                    int jj=cur[1]+curNear[1];
                    if(ii>=0&&ii<row&&jj>=0&&jj<col&&grid[ii][jj]==0){
                        queue.add(new int[]{ii,jj});
                        grid[ii][jj]=1;
                        peopleNumber--;
                    }
                }
            }
        }
        if(peopleNumber==0)
            return time;
        return -1;
        // write your code here
    }
}
