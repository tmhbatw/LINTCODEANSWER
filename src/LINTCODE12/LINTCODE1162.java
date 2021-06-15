package LINTCODE12;

public class LINTCODE1162 {
    /*Description
    *给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、
    * 右四个方向上移动使球穿过网格边界。但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 10^9 + 7 的值。
    * */

    public int findPaths(int m, int n, int N, int i, int j) {
        int[][] matrix=new int[m][n];
        int result=0;
        int mod=1000000007;
        matrix[i][j]=1;
        int[][] next=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while(N-->0){
            int[][] curMatrix=new int[m][n];
            for(int k=0;k<m;k++){
                for(int l=0;l<n;l++){
                    int time=matrix[k][l];
                    for(int[] nextPos:next){
                        int ii=k+nextPos[0];
                        int jj=l+nextPos[1];
                        if(ii<m&&ii>=0&&jj<n&&jj>=0)
                            curMatrix[ii][jj]=(curMatrix[ii][jj]+time)%mod;
                        else
                            result=(result+time)%mod;
                    }
                }
            }
            matrix=curMatrix;
        }
        return result;
        // Write your code here
    }
}
