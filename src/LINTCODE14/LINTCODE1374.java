package LINTCODE14;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1374 {
    /*Description
    * 给定一个整数N表示N*N*N的空间，每一个坐标数组表示障碍的位置，返回从(0,0,0) 到(N-1,N-1,N-1)的最小的步数。如果不能到达则返回-1。
    * */

    public int shortestDistance(int N, int[][] barriers) {
        if(N==1)
            return 0;
        boolean[][][] reached=new boolean[N][N][N];
        N--;
        for(int [] cur:barriers){
            if(cur[0]==N&&cur[1]==N&&cur[2]==N)
                return -1;
            reached[cur[0]][cur[1]][cur[2]]=true;
        }
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0,0});
        reached[0][0][0]=true;
        int time=0;
        int[][] near=new int[][]{{0,0,1},{0,0,-1},{0,1,0},{0,-1,0},{1,0,0},{-1,0,0}};
        while(!queue.isEmpty()){
            time++;
            int size=queue.size();
            while(size-->0){
                int[] cur=queue.poll();
                for(int[] curNear:near){
                    int ii=curNear[0]+cur[0];
                    int jj=curNear[1]+cur[1];
                    int kk=curNear[2]+cur[2];
                    if(ii==N&&jj==N&&kk==N)
                        return time;
                    if(ii>=0&&ii<=N&&jj>=0&&jj<=N&&kk>=0&&kk<=N&&!reached[ii][jj][kk]){
                        reached[ii][jj][kk]=true;
                        queue.add(new int[]{ii,jj,kk});
                    }
                }
            }
        }
        return -1;
        // Write your code here
    }
}
