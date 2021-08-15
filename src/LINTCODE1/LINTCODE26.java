package LINTCODE1;

public class LINTCODE26 {

    public long getMaxInnerProduct(int[] A, int[] B) {
        int length=B.length;
        long[][] dp=new long[length][length+1];
        int lengthA=A.length;
        dp[0][0]= (long) B[0] *A[lengthA-1];
        dp[0][1]=(long)B[0]*A[0];
        for(int i=1;i<length;i++){
            dp[i][0]=dp[i-1][0]+ (long) B[i] *A[lengthA-1-i];
            dp[i][i+1]=dp[i-1][i]+(long)B[i]*A[i];
            for(int j=1;j<=i;j++){
                dp[i][j]=Math.max(dp[i-1][j]+(long)B[i]*A[lengthA-1-(i-j)],
                        dp[i-1][j-1]+(long)B[i]*A[j-1]);
            }
        }
        long result=Long.MIN_VALUE;
        for(int j=0;j<=length;j++)
            result=Math.max(dp[length-1][j],result);
        return result;
        // write your code here
    }
}
