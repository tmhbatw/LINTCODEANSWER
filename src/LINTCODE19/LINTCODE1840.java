package LINTCODE19;

public class LINTCODE1840 {
    /*Description
    * 现有一个nn行mm列的矩阵before，对于before里的每一个元素before[i][j]，我们会使用以下算法将其转化为after[i][j]。
    * 现给定after矩阵，请还原出原有的矩阵before。
    * */

    public int[][] matrixRestoration(int n, int m, int[][] after) {
        if(n==0)
            return after;
        int[][] result=new int[n][m];
        result[0][0]=after[0][0];
        for(int i=1;i<m;i++){
            result[0][i]=after[0][i]-after[0][i-1];
        }
        for(int i=1;i<n;i++){
            result[i][0]=after[i][0]-after[i-1][0];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++)
                result[i][j]=after[i][j]-after[i-1][j]-after[i][j-1]+after[i-1][j-1];
        }
        return result;
        // write your code here
    }

}
