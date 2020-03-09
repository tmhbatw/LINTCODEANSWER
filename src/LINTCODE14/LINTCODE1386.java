package LINTCODE14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LINTCODE1386 {
    /*Description
    *小九来到某地坐缆车，他的钱只能坐一次缆车，所以他想尽量延长坐缆车的时间。已知缆车站分布可以看作是一个n x m的矩阵，
    * 每个格点代表缆车站的高度。他可以从任一站点开始坐缆车，缆车只能从矮的高度移动到高的高度，
    * 花费1单位的时间。缆车可以朝着八个方向移动。（上下左右、左上、左下、右上、右下）问小九最多能坐多久缆车？
    * */

    public int cableCarRide(int[][] height) {
        int row=height.length;
        int col=height[0].length;
        int[][] time=new int[row][col];
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)
                queue.add(new int[]{i,j,height[i][j]});
        }
        int[][] near=new int[][]{{-1,0},{-1,-1},{-1,1},{0,1},{0,-1},{1,-1},{1,0},{1,1}};
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            for(int[] curNear:near){
                int ii=cur[0]+curNear[0];
                int jj=cur[1]+curNear[1];
                if(ii>=0&&ii<row&&jj>=0&&jj<col&&height[ii][jj]>cur[2])
                    time[ii][jj]=Math.max(time[ii][jj],time[cur[0]][cur[1]]+1);
            }
        }
        for(int[] cur:time)
            System.out.println(Arrays.toString(cur));
        int result=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)
                result=Math.max(result,time[i][j]);
        }
        return result;
        // Write your code here
    }
}
