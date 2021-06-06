package LINTCODE8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LINTCODE778 {
    /*Description
    * 给定一个m×n的非负矩阵代表一个大洲，矩阵的每个单元格的值代表此处的地形高度，矩阵的左边缘和上边缘是“太平洋”，下边缘和右边缘是“大西洋”。
    * 水流只能在四个方向（上，下，左或右）从一个单元格流向另一个海拔和自己相等或比自己低的单元格。
    * 找到那些从此处出发的水既可以流到“太平洋”，又可以流向“大西洋”的单元格的坐标。
    * */

    int[][] near=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] res=new int[m][n];
        boolean[][] reached=new boolean[m][n];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            res[i][0]++;
            q.add(new int[]{i,0});
            reached[i][0]=true;
        }
        for(int j=1;j<n;j++){
            res[0][j]++;
            q.add(new int[]{0,j});
            reached[0][j]=true;
        }
        bfs(q,m,n,reached,res,matrix);
        reached=new boolean[m][n];
        for(int i=0;i<m;i++){
            res[i][n-1]++;
            q.add(new int[]{i,n-1});
            reached[i][n-1]=true;
        }
        for(int j=1;j<n;j++){
            res[m-1][j]++;
            q.add(new int[]{m-1,j});
            reached[m-1][j]=true;
        }
        bfs(q,m,n,reached,res,matrix);
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(res[i][j]==2){
                    List<Integer> list=new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }
        return result;
        // write your code here
    }

    private void bfs(Queue<int[]> q,int m,int n,boolean[][] reached,int[][] res,int[][] matrix){
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int[] nextPos:near){
                int ii=nextPos[0]+cur[0];
                int jj=nextPos[1]+cur[1];
                if(ii>=0&&ii<m&&jj>=0&&jj<n&&!reached[ii][jj]&&matrix[ii][jj]>=matrix[cur[0]][cur[1]]){
                    q.add(new int[]{ii,jj});
                    reached[ii][jj]=true;
                    res[ii][jj]+=1;
                }
            }
        }
    }

}
