package LINTCODE10;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE974 {
    /*Description
    * 给定一个由0和1组成的矩阵，求每个单元格最近的0的距离。
    * 两个相邻细胞之间的距离是1。
    * */




    public int[][] updateMatrix(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        boolean[][] reached=new boolean[row][col];
        int[][] result=new int[row][col];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0) {
                    q.add(new int[]{i,j});
                    reached[i][j]=true;
                }
            }
        }
        int[][] pos=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int distance=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                for(int[] nextPos:pos){
                    int ii=cur[0]+nextPos[0];
                    int jj=cur[1]+nextPos[1];
                    if(ii>=0&&ii<row&&jj>=0&&jj<col&&!reached[ii][jj]){
                        result[ii][jj]=distance;
                        reached[ii][jj]=true;
                        q.add(new int[]{ii,jj});
                    }
                }
            }
            distance++;
        }
        return result;
    }
}
