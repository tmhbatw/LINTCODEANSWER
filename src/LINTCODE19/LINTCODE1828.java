package LINTCODE19;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1828 {
    /*Description
    * Albert被困在结冰的湖面上。 他想知道他是否能回到岸上。 他目前在雪堆上，这给了他一些摩擦力。但一旦他踏进冰面，他会朝同一方向滑行，直到撞上另一个雪堆。 冰面上也有他必须避开的危险的洞。
    * Albert的小狗，Kuna，也被困在一个不同的雪堆上。 Albert能找到他的小狗并把它带到岸上吗？Albert只能水平和垂直移动。 他最终需要来到岸边，离开湖面
    * 输入包括以下参数：
    * side_length: 湖面的长度（这是一个正方形）
    * lake_grid: 一个二维数组代表湖面，其中0代表冰面，1代表雪堆，-1代表洞
    * albert_row: Albert所在的雪堆的行
    * albert_column: Albert所在的雪堆的列
    * kuna_row: Kuna所在的雪堆的行
    * kuna_column: Kuna所在的雪堆的列
    * */


    public boolean lakeEscape(int side_length, int[][] lake_grid, int albert_row, int albert_column, int kuna_row, int kuna_column) {
        return reachedDog(lake_grid,albert_row,albert_column,kuna_row,kuna_column)&&leave(lake_grid,kuna_row,kuna_column);
        // write your code here
    }

    private boolean leave(int[][] lake, int startX, int startY){
        int n=lake.length;
        if(startX==0||startX==n-1||startY==0||startY==n-1)
            return true;
        boolean[][] reached=new boolean[n][n];
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{startX,startY});
        reached[startX][startY]=true;
        int[][] nextPos=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int[] next:nextPos){
                int[] nextStepPos = getNext(next,cur,lake);
                if(lake[nextStepPos[0]][nextStepPos[1]]==-1)
                    continue;
                if((nextStepPos[0]==0||nextStepPos[0]==n-1||nextStepPos[1]==0||nextStepPos[1]==n-1))
                    return true;
                if(lake[nextStepPos[0]][nextStepPos[1]]==1&&!reached[nextStepPos[0]][nextStepPos[1]]){
                    reached[nextStepPos[0]][nextStepPos[1]]=true;
                    q.add(nextStepPos);
                }
            }
        }
        return false;
    }

    private boolean reachedDog(int[][] lake,int startX,int startY,int endX, int endY){
        int n=lake.length;
        boolean[][] reached=new boolean[n][n];
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{startX,startY});
        reached[startX][startY]=true;
        int[][] nextPos=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            for(int[] next:nextPos){
                int[] nextStepPos = getNext(next,cur,lake);
                if(!reached[nextStepPos[0]][nextStepPos[1]]&&lake[nextStepPos[0]][nextStepPos[1]]==1){
                    if(nextStepPos[0]==endX&&nextStepPos[1]==endY)
                        return true;
                    reached[nextStepPos[0]][nextStepPos[1]]=true;
                    queue.add(nextStepPos);
                }
            }
        }
        return false;
    }

    private int[] getNext(int[] next, int[] cur,int[][] lake){
        int i=cur[0],j=cur[1];
        int n=lake.length;
        while(i+next[0]<n&&i+next[0]>=0&&j+next[1]<n&&j+next[1]>=0){
            i+=next[0];
            j+=next[1];
            if(lake[i][j]!=0)
                break;
        }
        return new int[]{i,j};
    }
}
