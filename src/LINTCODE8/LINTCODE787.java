package LINTCODE8;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE787 {
    /*Description
    * 在迷宫中有一个球，里面有空的空间和墙壁。球可以通过滚上，下，左或右移动，
    * 但它不会停止滚动直到撞到墙上。当球停止时，它可以选择下一个方向。
    * 给定球的起始位置，目的地和迷宫，确定球是否可以停在终点。
    * 迷宫由二维数组表示。1表示墙和0表示空的空间。你可以假设迷宫的边界都是墙。开始和目标坐标用行和列索引表示。
    * */

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int row=maze.length,col=maze[0].length;
        boolean[][] reached=new boolean[row][col];
        int[][] next=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        Queue<int[]> q=new LinkedList<>();
        q.add(start);
        reached[start[0]][start[1]]=true;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int[] nextPos:next){
                int i=cur[0];
                int j=cur[1];
                while(i+nextPos[0]>=0&&i+nextPos[0]<row&&j+nextPos[1]>=0&&j+nextPos[1]<col
                    &&maze[i+nextPos[0]][j+nextPos[1]]!=1){
                    i+=nextPos[0];
                    j+=nextPos[1];
                }
                if(reached[i][j])
                    continue;
                if(i==destination[0]&&j==destination[1])
                    return true;
                reached[i][j]=true;
                q.add(new int[]{i,j});
            }
        }
        return false;
        // write your code here
    }
}
