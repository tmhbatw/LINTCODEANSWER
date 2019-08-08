package LINTCODE7;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE663 {
    /*Description
    * 您将获得一个使用这三个可能值初始化的 m×n 2D 网格。
    * -1 - 墙壁或障碍物。
    * 0 - 门。
    * INF - Infinity是一个空房间。我们使用值 2 ^ 31 - 1 = 2147483647 来表示INF，您可以假设到门的距离小于 2147483647。
    * 在代表每个空房间的网格中填入到距离最近门的距离。如果不可能到达门口，则应填入 INF。
    * */
    int[][] near=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j]==0)
                    queue.add(new int[]{i,j});
            }
        }
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            for(int[] curNear:near){
                int ii=cur[0]+curNear[0];
                int jj=cur[1]+curNear[1];
                if(ii<0||ii>=rooms.length||jj<0||jj>=rooms[0].length)
                    continue;
                if(rooms[ii][jj]==-1||rooms[ii][jj]<=rooms[cur[0]][cur[1]]+1)
                    continue;
                rooms[ii][jj]=rooms[cur[0]][cur[1]]+1;
                queue.add(new int[]{ii,jj});
            }
        }
        // write your code here
    }
}
