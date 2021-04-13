package LINTCODE14;

import java.util.*;

public class LINTCODE1364 {
    /*Description
    * 给出一个2维的表格图，其中每个格子上有一个数字num
    * 如果num是-2表示这个点是起点，num是-3表示这个点是终点，num是-1表示这个点是障碍物不能行走，num为 0 表示这个点是道路可以正常行走
    * 如果num是正数，表示这个点 是传送门，则这个点可以花费1的代价到达有着相同数字的传送门格子中
    * 每次可以花费1的代价向上下左右四个方向之一行走一格，传送门格子也可以往四个方向走求出从起点到终点的最小花费，如果不能到达返回-1
    * */

    public int getMinDistance(int[][] mazeMap) {
        int row=mazeMap.length,col=mazeMap[0].length;
        Map<Integer, List<int[]>> map=new HashMap<>();
        Queue<int[]> q=new LinkedList<>();
        boolean[][] reached=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mazeMap[i][j]==-2){
                    q.add(new int[]{i,j});
                    reached[i][j]=true;
                }
                else if(mazeMap[i][j]>0){
                    int val=mazeMap[i][j];
                    if(!map.containsKey(val)){
                        map.put(val,new ArrayList<>());
                    }
                    List<int[]> list=map.get(val);
                    list.add(new int[]{i,j});
                }
            }
        }
        int cost=0;
        int[][] pos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        boolean[] type=new boolean[51];
        while(!q.isEmpty()){
            cost++;
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                for(int[] nextPos:pos){
                    int ii=cur[0]+nextPos[0],jj=cur[1]+nextPos[1];
                    if(ii>=0&&ii<row&&jj>=0&&jj<col&&!reached[ii][jj]){
                        if(mazeMap[ii][jj]==-3)
                            return cost;
                        if(mazeMap[ii][jj]>=0){
                            reached[ii][jj]=true;
                            q.add(new int[]{ii,jj});
                        }
                    }
                }
                if(mazeMap[cur[0]][cur[1]]>0&&!type[mazeMap[cur[0]][cur[1]]]){
                    type[mazeMap[cur[0]][cur[1]]]=true;
                    List<int[]> list=map.get(mazeMap[cur[0]][cur[1]]);

                    for(int[] curr:list){
                        if(!reached[curr[0]][curr[1]]){
                            reached[curr[0]][curr[1]]=true;
                            q.add(curr);
                        }
                    }
                }
            }
        }
        return -1;
        // write your code here
    }
}
