package LINTCODE6;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LINTCODE573 {
    /*Description
    * 给出一个二维的网格，每一格可以代表墙 2 ，房子 1，以及空 0 (用数字0,1,2来表示)，在网格中找到一个位置去建立邮局，使得所有的房子到邮局的距离和是最小的。
    *返回所有房子到邮局的最小距离和，如果没有地方建立邮局，则返回-1.
    * */

    int[][] near=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int shortestDistance(int[][] grid) {
        int house=0;
        //用来保存每个点能联通的房子数目
        int[][] houses=new int[grid.length][grid[0].length];
        //用来保存距离数目
        int[][] times=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    house++;
                    //用来保存已经遍历过的网格
                    Set<String> set=new HashSet<>();
                    set.add(i+""+j);
                    int time=0;
                    Queue<int[]> queue=new LinkedList<>();
                    queue.add(new int[]{i,j});
                    while(!queue.isEmpty()){
                        time++;
                        int size=queue.size();
                        while(size-->0){
                            int[] cur=queue.poll();
                            for(int[] curNear:near){
                                int ii=cur[0]+curNear[0];
                                int jj=cur[1]+curNear[1];
                                if(ii<0||ii>=grid.length||jj<0||jj>=grid[0].length)
                                    continue;
                                if(grid[ii][jj]==1||grid[ii][jj]==2||set.contains(ii+""+jj))
                                    continue;
                                set.add(ii+""+jj);
                                queue.add(new int[]{ii,jj});
                                houses[ii][jj]++;
                                times[ii][jj]+=time;
                            }
                        }
                    }
                }
            }
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<houses.length;i++){
            for(int j=0;j<houses[0].length;j++){
                if(houses[i][j]==house)
                    res=Math.min(res,times[i][j]);
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
        // write your code here
    }
}
