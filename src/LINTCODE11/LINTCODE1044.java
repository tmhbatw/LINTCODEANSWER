package LINTCODE11;

public class LINTCODE1044 {
    /*Description
    * 在一个从(0, 0)到(N - 1, N - 1)的2D的网格当中，除了mines中列出的点为0，其他所有的点为1，
    * 求出网格中所有的由1组成的最大轴对齐加号。按顺序返回所有的加号。如果没有，返回0。
    * 一个“k阶最大轴对齐加号”的中心点grid[x][y] = 1，并且上下左右分别有四个边，长度为k - 1，这四个边也由1组成。
    * 具体可见下方的例子。加号的边外侧可能是1也可能是0，只需要检查相关区域是否为1即可。
    * 排在第k位的、由1组成的最大轴对齐加号样例
    * */

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] matrix=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                matrix[i][j]=1;
            }
        }
        for(int[] cur:mines){
            matrix[cur[0]][cur[1]]=0;
        }
        int row=N,col=N;
        int[][] dp1=new int[row][col];//用来表示左边的最大加号
        int[][] dp2=new int[row][col];
        int[][] dp3=new int[row][col];
        int[][] dp4=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==1){
                    dp1[i][j]=1;
                    dp2[i][j]=1;
                    if(j>0){
                        dp1[i][j]+=dp1[i][j-1];
                    }
                    if(i>0){
                        dp2[i][j]+=dp2[i-1][j];
                    }
                }
            }
        }
        int result=0;
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                if(matrix[i][j]==1) {
                    dp3[i][j]=1;
                    dp4[i][j]=1;
                    if(i<row-1){
                        dp3[i][j]+=dp3[i+1][j];
                    }
                    if(j<col-1){
                        dp4[i][j]+=dp4[i][j+1];
                    }
                    result = Math.max(result, Math.min(Math.min(dp1[i][j], dp2[i][j]), Math.min(dp3[i][j], dp4[i][j])));
                }
            }
        }
        return result;
        // Write your code here
    }
}
