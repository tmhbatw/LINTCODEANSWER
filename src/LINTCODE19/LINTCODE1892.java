package LINTCODE19;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LINTCODE1892 {
    /*Description
    * 现在有一个简易版的扫雷游戏，你将得到一个n*m大小的二维数组作为游戏地图。每个位置上有一个值（0或1，1代表此处没有雷，0表示有雷）。
    * 你将获得一个起点的位置坐标（x，y），x表示所在行数，y表示所在列数（x，y均从0开始计数）。
    * 若当下位置上没有雷，则上下左右四个方向均可以到达，若当下位置有雷，则不能再往新的方向移动。
    * 请问一共有哪些位置是可以到达的呢？
    * */

    public List<List<Integer>> Mine_sweeping(int[][] Mine_map, int[] Start) {
        int row=Mine_map.length, col=Mine_map[0].length;
        boolean[][] reached=new boolean[row][col];
        List<List<Integer>> result=new ArrayList<>();
        reached[Start[0]][Start[1]]=true;
        List<Integer> res=new ArrayList<>();
        res.add(Start[0]);
        res.add(Start[1]);
        result.add(res);
        Queue<int[]> queue=new LinkedList<>();
        if(Mine_map[Start[0]][Start[1]]==1)
            queue.add(Start);
        int[][] near=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            for(int[] curNear:near){
                int i=cur[0]+curNear[0];
                int j=cur[1]+curNear[1];
                if(i>=0&&i<row&&j>=0&&j<col&&!reached[i][j]){
                    reached[i][j]=true;
                    List<Integer> list=new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                    if(Mine_map[i][j]==1)
                        queue.add(new int[]{i,j});
                }
            }
        }
        return result;
        // write your code here
    }
}
