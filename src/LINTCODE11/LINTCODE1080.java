package LINTCODE11;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1080 {
    /*Description
    * 给定一个由0和1组成的非空二维数组grid，一个岛由一组四联通（上下左右四方向）的1（表示陆地）组成。假定grid的四周都是水。
    * 返回最大的岛。（没有岛则返回0）
    * */

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] reached=new boolean[grid.length][grid[0].length];
        int max=0;
        int[][] near=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1&&!reached[i][j]){
                    int curArea=0;
                    Queue<int[]> queue=new LinkedList<>();
                    queue.add(new int[]{i,j});
                    reached[i][j]=true;
                    while(!queue.isEmpty()){
                        curArea++;
                        int[] cur=queue.poll();
                        System.out.println(cur[0]+" "+cur[1]);
                        for(int[] curr:near){
                            int ii=cur[0]+curr[0];
                            int jj=cur[1]+curr[1];
                            if(ii>=0&&ii<grid.length&&jj>=0&&jj<grid[0].length&&grid[ii][jj]==1&&!reached[ii][jj]) {
                                queue.add(new int[]{ii, jj});
                                reached[ii][jj]=true;
                            }
                        }
                    }
                    max=Math.max(max,curArea);
                }
            }
        }
        return max;
        // Write your code here
    }
}
