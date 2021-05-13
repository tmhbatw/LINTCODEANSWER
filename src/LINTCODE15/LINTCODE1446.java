package LINTCODE15;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1446 {

    /*Description
    * 给定一个大小为 n*m 的 01 矩阵 grid ，1 是墙，0 是路，你现在可以把 grid 中的一个 1 变成 0，
    * 请问从左上角走到右下角是否有路可走？如果有路可走，最少要走多少步？
    * */
    int[][] pos=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int getBestRoad(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        if(m==1&&n==1)
            return 0;
        int[][] disFromStart=new int[m][n];
        Queue<int[]> q=new LinkedList<>();
        if(grid[0][0]!=1){
            q.add(new int[]{0,0});
        }
        getDis(q,disFromStart,m,n,grid);
        int[][] disFromEnd=new int[m][n];
        q.add(new int[]{m-1,n-1});
        getDis(q,disFromEnd,m,n,grid);
        for(int[] cur:disFromEnd)
            System.out.println(Arrays.toString(cur));
        System.out.println();
        for(int[] cur:disFromStart)
            System.out.println(Arrays.toString(cur));
        int result=disFromEnd[0][0]==0?Integer.MAX_VALUE:disFromEnd[0][0]-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    for(int[] nextPos:pos){
                        int i1=i+nextPos[0];
                        int i2=i-nextPos[0];
                        int j1=j+nextPos[1];
                        int j2=j-nextPos[1];
                        if(i1>=0&&i1<m&&i2>=0&&i2<m&&j1>=0&&j1<n&&j2>=0&&j2<n){
                            if(disFromEnd[i1][j1]>0&&disFromStart[i2][j2]>0)
                                result=Math.min(result,disFromEnd[i1][j1]+disFromStart[i2][j2]);
                        }
                    }
                }
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
        // Write your code here
    }

    private void getDis(Queue<int[]> q,int[][] disFromStart,int m,int n,int[][] grid){
        int dis=1;
        if(!q.isEmpty())
            disFromStart[q.peek()[0]][q.peek()[1]]=1;
        while(!q.isEmpty()){
            int size=q.size();
            dis++;
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                for(int[] nextPos:pos){
                    int ii=cur[0]+nextPos[0];
                    int jj=cur[1]+nextPos[1];
                    if(ii>=0&&ii<m&&jj>=0&&jj<n&&disFromStart[ii][jj]==0&&grid[ii][jj]==0){
                        q.add(new int[]{ii,jj});
                        disFromStart[ii][jj]=dis;
                    }
                }
            }
        }
    }
}
