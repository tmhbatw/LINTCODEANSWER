package LINTCODE20;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1911 {
    /*Description
    * 你现在手里有一份大小为 N x N 的网格grid，上面的每个单元格都用 0 和 1 标记好了。
    * 其中 0 代表海洋，1 代表陆地，请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的。
    * 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 - x1| + |y0 - y1| 。
    * 如果网格上只有陆地或者海洋，请返回 -1。
    * */

    public int maxDistance(int[][] grid) {
        int result=-1;
        int first=grid[0][0];
        boolean isSame=true;
        int row=grid.length,col=grid[0].length;
        for(int i=0;i<row&&isSame;i++){
            for(int j=0;j<col&&isSame;j++){
                if(grid[i][j]!=first)
                    isSame=false;
            }
        }
        if(isSame)
            return -1;
        int[][] pos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0){
                    boolean[][] reached=new boolean[row][col];
                    reached[i][j]=true;
                    Queue<int[]> q=new LinkedList<>();
                    q.add(new int[]{i,j});
                    int distance=1;
                    boolean breakFlag=true;
                    while(!q.isEmpty()&&breakFlag){
                        int size=q.size();
                        for(int k=0;k<size&&breakFlag;k++){
                            int[] cur=q.poll();
                            for(int[] nextPos:pos){
                                int ii=cur[0]+nextPos[0];
                                int jj=cur[1]+nextPos[1];
                                if(ii>=0&&ii<row&&jj>=0&&jj<col&&!reached[ii][jj]){
                                    if(grid[ii][jj]==1){
                                        breakFlag=false;
                                        result=Math.max(result,distance);
                                    }else{
                                        q.add(new int[]{ii,jj});
                                        reached[ii][jj]=true;
                                    }
                                }
                            }
                        }
                        distance++;
                    }
                }
            }
        }
        return result;
        // Write your code here.
    }
}
