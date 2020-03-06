package LINTCODE15;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1479 {
    /*Description
    * 给一个大小为 m*n 的map，1 代表空地，0 代表障碍物，9代表终点。请问如果你从 (0, 0) 开始能否到达终点？
    * */

    public boolean reachEndpoint(int[][] map) {
        int[][] near=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0});
        map[0][0]=0;
        int row=map.length;
        int col=map[0].length;
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            for(int[] curNear:near){
                int ii=cur[0]+curNear[0];
                int jj=cur[1]+curNear[1];
                if(ii<row&&ii>=0&&jj<col&&jj>=0){
                    if(map[ii][jj]==9)
                        return true;
                    if(map[ii][jj]==1){
                        queue.add(new int[]{ii,jj});
                        map[ii][jj]=0;
                    }
                }
            }
        }
        return false;
        // Write your code here
    }
}
