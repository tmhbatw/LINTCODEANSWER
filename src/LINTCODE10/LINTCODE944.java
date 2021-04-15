package LINTCODE10;

public class LINTCODE944 {
    /*Description
    *给出一个大小为 n x n 的矩阵，里面元素为 正整数 和 负整数 ，找到具有最大和的子矩阵
    * */

    public int maxSubmatrix(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0)
            return 0;
        int row=matrix.length,col=matrix[0].length;
        int result=matrix[0][0];
        for(int i=0;i<row;i++){
            int[] dp=new int[col];
            for(int j=i;j<row;j++){
                int preMin=0;
                int[] curDp=new int[col];
                for(int l=0;l<col;l++){
                    dp[l]+=matrix[j][l];
                    curDp[l]=dp[l];
                    if(l>0)
                        curDp[l]+=curDp[l-1];
                    result=Math.max(result,curDp[l]-preMin);
                    preMin=Math.min(preMin,curDp[l]);
                }
            }
        }
        return result;
        // write your code here
    }
}
