package LINTCODE10;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LINTCODE941 {
    /*Description
    * 在一块大小为 2x3 的板上，有 5 块瓦片，分别用整数 1 到 5 表示，还有一块空地用 0 表示。
    * 一次移动表示 0 与其相邻的四个方向之一的数字交换位置。
    * 当且仅当 这块板 上的瓦片摆放状态为 [[1,2,3],[4,5,0]] 时，才能说这块板存在的问题被解决了。
    * 给定一个拼图板，返回所需的最少移动次数，以解决该板的状态。如果无法解决板的状态，则返回-1。
    * */

    int target=123450;
    int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int slidingPuzzle(int[][] board) {
        int type=getType(board);
        if(type==target)
            return 0;
        Set<Integer> set=new HashSet<>();
        Queue<int[][]> q=new LinkedList<>();

        set.add(type);
        q.add(board);
        int distance=0;
        while(!q.isEmpty()){
            distance++;
            int size=q.size();
            while(size-->0){
                int[][] cur=q.poll();
                int i=0;int j=0;
                for(int ii=0;ii<2;ii++){
                    for(int jj=0;jj<3;jj++){
                        if(cur[ii][jj]==0){
                            i=ii;
                            j=jj;
                        }
                    }
                }

                for(int[] next:nextPos){
                    int ii=next[0]+i;
                    int jj=next[1]+j;
                    if(ii<2&&ii>=0&&jj<3&&jj>=0){
                        int[][] nextCur=new int[2][3];
                        for(int m=0;m<2;m++)
                            nextCur[m]=cur[m].clone();
                        nextCur[i][j]=nextCur[ii][jj];
                        nextCur[ii][jj]=0;
                        int curType=getType(nextCur);
                        if(curType==target)
                            return distance;
                        if(!set.contains(curType)){
                            set.add(curType);
                            q.add(nextCur);
                        }
                    }
                }
            }
        }
        return -1;
        // write your code here
    }

    private int getType(int[][] board){
        int result=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                result*=10;
                result+=board[i][j];
            }
        }
        return result;
    }
}
