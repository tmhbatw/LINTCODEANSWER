package LINTCODE7;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE677 {
    /*Description
    *给一个布尔类型的二维数组, 0 表示海, 1 表示岛。如果两个1是相邻的,那么我们认为他们是同一个岛.我们只考虑 上下左右 相邻.
    * 找到大小在 k 及 k 以上的岛屿的数量
    * */

    int[][] near=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int numsofIsland(boolean[][] grid, int k) {
        int res=0;
        Queue<int[]> queue=new LinkedList<>();
        boolean[][] searched=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!grid[i][j]||searched[i][j])
                    continue;
                int area=0;
                queue.add(new int[]{i,j});
                while(!queue.isEmpty()){
                    int[] cur=queue.poll();
                    area++;
                    for(int[] curNear:near){
                        int ii=cur[0]+curNear[0];
                        int jj=cur[1]+curNear[1];
                        if(ii<0||ii>grid.length-1||jj<0||jj>grid[0].length-1)
                            continue;
                        if(searched[ii][jj]||!grid[ii][jj])
                            continue;
                        searched[ii][jj]=true;
                        queue.add(new int[]{ii,jj});
                    }
                }
                if(area>=k)
                    res++;
            }
        }
        return res;
        // Write your code here
    }


}
