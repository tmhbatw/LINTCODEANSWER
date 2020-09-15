package LINTCODE17;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LINTCODE1685 {
    /*Description
    * 给你一个地图，其中‘S’表示起点，'T'表示终点。‘#’代表墙壁表示无法通过,'.’表示路可以花一分钟通过。
    * 请你求出从起点到终点需要花费的最短时间。如果无法到达终点请输出-1。
    * */

    public int theMazeIV(char[][] maps) {
        Queue<int[]> stack=new LinkedList<>();
        int row=maps.length,col=maps[0].length;
        boolean[][] reached=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(maps[i][j]=='S') {
                    stack.add(new int[]{i, j});
                    reached[i][j]=true;
                    break;
                }
            }
        }
        int step=0;
        int[][] pos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while(!stack.isEmpty()){
            step++;
            int size=stack.size();
            while(size-->0){
                int[] cur=stack.poll();
                int i=cur[0],j=cur[1];
                for(int[] curPos:pos){
                    int ii=i+curPos[0],jj=j+curPos[1];
                    if(ii<row&&ii>=0&&jj<col&&jj>=0&&!reached[ii][jj]&&maps[ii][jj]!='#'){
                        if(maps[ii][jj]=='T')
                            return step;
                        stack.add(new int[]{ii,jj});
                        reached[ii][jj]=true;
                    }
                }
            }
        }
        return -1;
        //
    }
}
