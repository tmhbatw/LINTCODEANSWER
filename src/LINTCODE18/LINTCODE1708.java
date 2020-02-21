package LINTCODE18;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1708 {
    /*Description
    * 在给定的二维二进制数组 A中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
    * 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。
    * 返回必须翻转的 0 的最小数目。（可以保证答案至少是 1。）
    * */

    public int ShortestBridge(int[][] A) {
        int[][] near=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        boolean index=true;
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j]==1&&index){
                    index=false;
                    Queue<int[]> cur=new LinkedList<>();
                    cur.add(new int[]{i,j});
                    while(!cur.isEmpty()){
                        int[] pop=cur.poll();
                        queue.add(pop);
                        A[pop[0]][pop[1]]=-1;
                        for(int[] curNear:near){
                            int ii=pop[0]+curNear[0];
                            int jj=pop[1]+curNear[1];
                            if(ii>=0&&ii<A.length&&jj>=0&&jj<A[0].length){
                                if(A[ii][jj]==1){
                                    cur.add(new int[]{ii,jj});
                                }
                            }
                        }
                    }
                }
            }
        }
        int time=1;
        while(!queue.isEmpty()){
            time++;
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] cur=queue.poll();
                for(int[] curNear:near){
                    int ii=cur[0]+curNear[0];
                    int jj=cur[1]+curNear[1];
                    if(ii>=0&&ii<A.length&&jj>=0&&jj<A[0].length) {
                        if (A[ii][jj] == 1)
                            return time - 2;
                        if (A[ii][jj] == 0) {
                            A[ii][jj] =time;
                            queue.add(new int[]{ii,jj});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
