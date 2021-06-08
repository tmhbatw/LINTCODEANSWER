package LINTCODE6;

public class LINTCODE558 {

    public int maxSlidingMatrix(int[][] matrix, int k) {
        int m=matrix.length,n=matrix[0].length;
        if(n<k||m<k||k==0)
            return 0;
        int[][] dp=new int[m][n];
        for(int j=0;j<n;j++)
            dp[0][j]=matrix[0][j];
        for(int i=1;i<k;i++){
            for(int j=0;j<n;j++)
                dp[i][j]+=dp[i-1][j]+matrix[i][j];
        }
        for(int i=k;i<m;i++){
            for(int j=0;j<n;j++)
                dp[i][j]=dp[i-1][j]+matrix[i][j]-matrix[i-k][j];
        }

        int result=Integer.MIN_VALUE;
        for(int i=k-1;i<m;i++){
            int curRes=0;
            for(int j=0;j<k;j++)
                curRes+=dp[i][j];
            result=Math.max(result,curRes);
            for(int j=k;j<n;j++){
                curRes+=dp[i][j]-dp[i][j-k];
                result=Math.max(result,curRes);
            }
        }
        return result;
        // write your code here
    }
}
