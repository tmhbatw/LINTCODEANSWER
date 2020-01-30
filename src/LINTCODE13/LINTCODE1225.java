package LINTCODE13;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1225 {
    /*Description
    * 给定一张用二维数组表示的网格地图，其中1表示陆地单元格，0表示水域单元格。
    * 网格地图中的单元格视为水平/垂直相连（斜向不相连）。这个网格地图四周完全被水域包围着，
    * 并且其中有且仅有一个岛（定义为一块或多块相连的陆地单元格）。这个岛不包含湖（定义为不和外围水域相连的水域单元格）。
    * 一个地图单元格是边长为1的一个正方形；网格地图是一个矩形，并且它的长和宽不超过100。你要做的是求出这个岛的周长。
    * */


    /*Solution
    * 对于一片陆地，
    * 若其上方没有陆地，则贡献一条边；
    * 若其左方没有陆地，则贡献一条边；
    * 若其下方没有陆地，则贡献一条边；
    * 若其右方没有陆地，则贡献一条边；
    * 遍历所有陆地求出所有贡献和即可。
    * */

    static int[][] near=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int islandPerimeter(int[][] grid) {
        int result=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) {
                    result += 4;
                    for (int[] cur : near) {
                        int ii = i + cur[0];
                        int jj = j + cur[1];
                        if (ii >= 0 && ii < grid.length && jj >= 0 && jj < grid[0].length && grid[ii][jj] == 1)
                            result--;
                    }
                }
            }
        }
        return result;
        // Write your code here
    }




    /*Solution
    * 求出相连的陆地数然后计算边数，但是会超时
    * */
/*    static int[][] near=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int islandPerimeter(int[][] grid) {
        boolean[][] reached=new boolean[grid.length][grid[0].length];
        int result=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1&&!reached[i][j]){
                    System.out.println(i+" "+j);
                    Queue<int[]> queue=new LinkedList<>();
                    queue.add(new int[]{i,j});
                    int curSum=0;
                    while(!queue.isEmpty()){
                        int[] cur=queue.poll();
                        curSum++;
                        reached[cur[0]][cur[1]]=true;
                        for (int[] ints : near) {
                            int ii = cur[0] + ints[0];
                            int jj = cur[1] + ints[1];
                            if (ii >= 0 && ii < grid.length && jj >= 0 && jj < grid[0].length && !reached[ii][jj] && grid[ii][jj] == 1) {
                                System.out.println(" "+ii+" "+jj);
                                queue.add(new int[]{ii, jj});
                            }
                        }
                    }
                    result+=2*curSum+2;
                }
            }
        }
        return result;
        // Write your code here
    }*/
}
