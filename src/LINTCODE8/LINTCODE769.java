package LINTCODE8;

public class LINTCODE769 {
    /*Description
    * 给出整数 n, 返回一个大小为 n * n 的螺旋矩阵
    * */

    public int[][] spiralArray(int n) {
        int[][] result=new int[n][n];
        int index=1;
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i-1;j++){
                result[i][j]=index++;
            }
            for(int j=i;j<n-i-1;j++){
                result[j][n-i-1]=index++;
            }
            for(int j=i;j<n-i-1;j++){
                result[n-i-1][n-1-j]=index++;
            }
            for(int j=i;j<n-i-1;j++){
                result[n-j-1][i]=index++;
            }
        }
        if(n%2==1)
            result[n/2][n/2]=index;
        return result;
        // write your code here
    }
}
