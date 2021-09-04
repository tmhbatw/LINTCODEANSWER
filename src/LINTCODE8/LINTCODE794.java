package LINTCODE8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LINTCODE794 {
    /*Description
    * 在一个3x3的网格中，放着编号1到8的8块板，以及一块编号为0的空格。
    * 一次移动可以把空格0与上下左右四邻接之一的板子交换。
    * 给定初始和目标的板子排布，返回到目标排布最少的移动次数。
    * 如果不能从初始排布移动到目标排布，返回-1.
    * */

    int target;
    int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int minMoveStep(int[][] init_state, int[][] final_state) {
        target=getType(final_state);
        int type=getType(init_state);
        if(type==target)
            return 0;

        Set<Integer> set=new HashSet<>();
        Queue<int[][]> q=new LinkedList<>();

        set.add(type);
        q.add(init_state);
        int distance=0;
        while(!q.isEmpty()){
            distance++;
            int size=q.size();
            while(size-->0){
                int[][] cur=q.poll();
                int i=0;int j=0;
                for(int ii=0;ii<3;ii++){
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
                    if(ii<3&&ii>=0&&jj<3&&jj>=0){
                        int[][] nextCur=new int[3][3];
                        for(int m=0;m<3;m++)
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
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                result*=10;
                result+=board[i][j];
            }
        }
        return result;
    }
}
