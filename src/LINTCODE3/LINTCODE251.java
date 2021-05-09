package LINTCODE3;

public class LINTCODE251 {
    /*Description
    * 现在给你一个3×N的二维数组，你需要将其压缩成一个一维数组。
    * 压缩的方法是从原数组A[3][N]每列中取一个数，得到一个大小为N的一维数组B[N]。
    * 这样的数组很多，题目希望数组能使以下值最小：
    * 求出这个最小值。
    * */

    public int CompressArray(int[][] A) {
        int length=A[0].length;
        int[][] dp=new int[3][length];
        for(int i=1;i<length;i++){
            dp[0][i]=Math.min(Math.min(dp[1][i-1]+Math.abs(A[1][i-1]-A[0][i]),
                    dp[2][i-1]+Math.abs(A[2][i-1]-A[0][i])),dp[0][i-1]+Math.abs(A[0][i-1]-A[0][i]));
            dp[1][i]=Math.min(Math.min(dp[1][i-1]+Math.abs(A[1][i-1]-A[1][i]),
                    dp[2][i-1]+Math.abs(A[2][i-1]-A[1][i])),dp[0][i-1]+Math.abs(A[0][i-1]-A[1][i]));
            dp[2][i]=Math.min(Math.min(dp[1][i-1]+Math.abs(A[1][i-1]-A[2][i]),
                    dp[2][i-1]+Math.abs(A[2][i-1]-A[2][i])),dp[0][i-1]+Math.abs(A[0][i-1]-A[2][i]));
        }
        return Math.min(Math.min(dp[0][length-1],dp[1][length-1]),dp[2][length-1]);
        //
    }
}
