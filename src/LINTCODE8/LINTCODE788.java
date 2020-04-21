package LINTCODE8;

import java.util.*;

public class LINTCODE788 {
    /*Description
    * 在迷宫中有一个球，里面有空的空间和墙壁。球可以通过滚上，下，左或右移动，但它不会停止滚动直到撞到墙上。当球停止时，它可以选择下一个方向。
    * 给定球的起始位置，目标和迷宫，找到最短距离的球在终点停留。距离是由球从起始位置(被排除)到目的地(包括)所走过的空空间的数量来定义的。如果球不能停在目的地，返回-1。
    * 迷宫由二维数组表示。1表示墙和0表示空的空间。你可以假设迷宫的边界都是墙。开始和目标坐标用行和列索引表示。
    * */

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m=maze.length;
        int n=maze[0].length;
        int[][] res=new int[m][n];
        for(int[] cur:res)
            Arrays.fill(cur,Integer.MAX_VALUE);
        res[start[0]][start[1]]=0;
        int[][] near=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue=new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            for(int[] curNear:near){
                int x=cur[0],y=cur[1];
                int time=res[x][y];
                while(x+curNear[0]<m&&x+curNear[0]>=0&&y+curNear[1]<n&&y+curNear[1]>=0&&maze[x+curNear[0]][y+curNear[1]]!=1){
                    x+=curNear[0];
                    y+=curNear[1];
                    time++;
                }
                if(x==destination[0]&&y==destination[1]) {
                    res[destination[0]][destination[1]]=Math.min(res[destination[0]][destination[1]],time);
                    continue;
                }
                if(time<res[x][y]){
                    res[x][y]=time;
                    queue.add(new int[]{x,y});
                }
            }
        }
        return res[destination[0]][destination[1]]==Integer.MAX_VALUE?-1:res[destination[0]][destination[1]];
        // write your code here
    }


}
