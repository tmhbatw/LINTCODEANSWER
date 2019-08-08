package LINTCODE14;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1367 {
    /*Description
    * 给一个n x m的矩阵，里面的值1代表那个位置站了一个警察，-1代表是墙，0代表是空地。
    * 现在请你输出一个n x m矩阵，输出每一个空地到离他最近的警察的距离。
    * */

    int[][] near=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int[][] policeDistance(int[][] matrix ) {
        int[][] res=new int[matrix.length][matrix[0].length];
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    res[i][j]=0;
                    queue.add(new int[]{i,j});
                }else if(matrix[i][j]==-1)
                    res[i][j]=-1;
                else
                    res[i][j]=Integer.MAX_VALUE;
            }
        }
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            int i=cur[0],j=cur[1];
            for(int[] curNear:near){
                int ii=i+curNear[0],jj=j+curNear[1];
                if(ii<0||ii>=matrix.length||jj<0||jj>=matrix[0].length)
                    continue;
                if(res[ii][jj]==-1||res[ii][jj]<=res[i][j]+1)
                    continue;
                res[ii][jj]=res[i][j]+1;
                queue.add(new int[]{ii,jj});
            }
        }
        return res;
    }
}