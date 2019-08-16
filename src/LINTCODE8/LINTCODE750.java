package LINTCODE8;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE750 {
    /*Description
    * Chell是Valve Corporation开发的Portal视频游戏系列中的主角。
    * 一天，她掉进了一个迷宫。迷宫可以看作是一个大小为n x m二维字符数组。它有4种房间。'S'代表Chell从哪开始（只有一个起点）。
    * 'E'代表迷宫的出口（当chell抵达时，她将离开迷宫，该题目可能会有多个出口）。'*'代表这个房间Chell可以经过。'#'代表一堵墙，Chell不能经过墙。
    * 她可以每次上下左右移动到达一个房间，花费一分钟时间，但是不能到达墙。
    * 现在，你能告诉我她最少需要多少时间离开这个迷宫吗？
    * 如果她不能离开，返回-1
    * */

    /*Solution
    * 从入口开始遍历而不是从重点
    * */

    int[][] near=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int Portal(char[][] Maze) {
        int[][] res=new int[Maze.length][Maze[0].length];
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<Maze.length;i++){
            for(int j=0;j<Maze[0].length;j++){
                char cur=Maze[i][j];
                switch (cur){
                    case 'E':
                    case '*':
                        res[i][j]=50000;
                        break;
                    case 'S':
                        queue.add(new int[]{i,j});
                        break;
                    case '#':
                        res[i][j]=-1;
                        break;
                }
            }
        }
        int temp=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++) {
                int[] cur = queue.poll();
                for (int[] curNear : near) {
                    int ii = cur[0] + curNear[0];
                    int jj = cur[1] + curNear[1];
                    if (ii < 0 || ii >= Maze.length || jj < 0 || jj >= Maze[0].length) {
                        continue;
                    }
                    if (res[ii][jj] == -1 || res[ii][jj] <= temp ) {
                        continue;
                    }
                    if(Maze[ii][jj]=='E'){
                        return temp;
                    }
                    res[ii][jj] = temp;
                    queue.add(new int[]{ii,jj});
                }
            }
            temp++;
        }
        return -1;
    }
}
