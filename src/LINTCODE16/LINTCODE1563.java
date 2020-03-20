package LINTCODE16;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1563 {
    /*Description
    * 给定表示地图上坐标的2D数组，地图上只有值0,1,2.0表示可以通过，1表示不可通过，2表示目标位置。从坐标[0,0]开始，
    * 你只能上，下，左，右移动。找到可以到达目的地的最短路径，并返回路径的长度。
    * */

    public int shortestPath(int[][] targetMap) {
        int[] target=new int[2];
        int row=targetMap.length;
        int col=targetMap[0].length;
        boolean[][] reached=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(targetMap[i][j]==1)
                    reached[i][j]=true;
                if(targetMap[i][j]==2) {
                    target[0] = i;
                    target[1] = j;
                }
            }
        }
        Queue<int[]> queue=new LinkedList<>();
        int[][] near=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        queue.add(new int[]{0,0});
        int time=-1;
        while(!queue.isEmpty()){
            time++;
            int size=queue.size();
            while(size-->0){
                int[] cur=queue.poll();
                int i=cur[0],j=cur[1];
                reached[i][j]=true;
                for(int[] curNear:near){
                    int ii=curNear[0]+i,jj=curNear[1]+j;
                    if(ii==target[0]&&jj==target[1])
                        return time+1;
                    if(ii>=0&&ii<row&&jj>=0&&jj<col&&!reached[ii][jj])
                        queue.add(new int[]{ii,jj});
                }
            }
        }
        return -1;
        // Write your code here
    }
}
