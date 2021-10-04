package LINTCODE14;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LINTCODE1391 {
    /*Description
    *在一个0和1的2D网格中，我们最多将一个0改为1。
    * 之后，最大岛屿的大小是多少？ （一个岛是四个方向上互相连接的一组1）。
    * */

    int row;
    int col;
    int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int largestIsland(int[][] grid) {
        this.row=grid.length;
        this.col=grid[0].length;
        int[][] type=new int[row][col];
        int[][] time=new int[row][col];
        int res=0;
        boolean[][] reached=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!reached[i][j]){
                    int curType=getType(i,j);
                    type[i][j]=curType;

                    if(grid[i][j]==0){
                        continue;
                    }

                    Queue<int[]> q=new LinkedList<>();
                    q.add(new int[]{i,j});
                    reached[i][j]=true;
                    int curTime=1;
                    while(!q.isEmpty()){
                        int[] cur=q.poll();
                        for(int[] next:nextPos){
                            int ii=next[0]+cur[0];
                            int jj=next[1]+cur[1];
                            if(ii>=0&&ii<row&&jj>=0&&jj<col&&!reached[ii][jj]&&grid[ii][jj]==1){
                                curTime++;
                                reached[ii][jj]=true;
                                type[ii][jj]=curType;
                                q.add(new int[]{ii,jj});
                            }
                        }
                    }

                    time[i][j]=curTime;
                    res=Math.max(res,curTime);
                }
            }
        }


        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0){
                    Set<Integer> typeSet=new HashSet<>();
                    for(int[] next:nextPos){
                        int ii=next[0]+i;
                        int jj=next[1]+j;
                        if(ii>=0&&ii<row&&jj>=0&&jj<col)
                            typeSet.add(type[ii][jj]);
                    }
                    int curRes=1;
                    for(int curType:typeSet){
                        int ii=curType/col;
                        int jj=curType%col;
                        curRes+=time[ii][jj];
                    }

                    res=Math.max(curRes,res);
                }
            }
        }

        return res;
        //
    }

    public int getType(int r, int c){
        return r*col+c;
    }
}
