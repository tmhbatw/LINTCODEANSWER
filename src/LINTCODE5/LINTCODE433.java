package LINTCODE5;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE433 {

    /*Description
    *Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island.
    * We only consider up/down/left/right adjacent.
    * Find the number of islands.
    * */

    /*Solution
    * 当发现一座岛屿后就将所有邻接的1全部遍历出来
    * (使用栈会导致内存溢出，只能使用递归）
    * */
    int[][] near=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public int numIslands(boolean[][] grid) {
        if(grid.length==0)
            return 0;
        boolean[][] searched=new boolean[grid.length][grid[0].length];
        int result=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(searched[i][j])
                    continue;
                if(!grid[i][j]){
                    searched[i][j]=true;
                }else{
                    result++;
                    recursion(searched,grid,i,j);
                }
            }
        }
        return result;
        // write your code here
    }

    private void recursion(boolean[] [] searched,boolean[] []grid,int x,int y){
        searched[x][y]=true;
        for(int[] cur:near){
            int curX=x+cur[0],curY=y+cur[1];
            if(curX<0||curX>=grid.length||curY<0||curY>=grid[0].length||searched[curX][curY])
                return;
            if(!grid[curX][curY]){
                searched[curX][curY]=true;
            }else{
                recursion(searched,grid,curX,curY);
            }
        }
    }


}
