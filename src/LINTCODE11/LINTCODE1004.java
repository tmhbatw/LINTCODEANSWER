package LINTCODE11;

public class LINTCODE1004 {
    /*Description
    * 我们将一行数字 A 分成最多 K 个相邻（非空）组，然后我们的分数是每组平均值的总和。我们可以获得的最高分是多少?
    * 请注意，我们的分区必须使用A中的每个数字，并且该分数不一定是整数。
    * */

    public double largestSumOfAverages(int[] A, int K) {
        if(A==null||A.length==0)
            return 0;
        int length=A.length;
        int[] sum=new int[length+1];
        double[][] dp=new double[K][length+1];
        sum[1]=A[0];
        dp[0][1]=A[0];
        for(int i=1;i<length;i++) {
            sum[i+1] += sum[i] + A[i];
            dp[0][i+1]=sum[i+1]*1.0/(i+1);
        }
        for(int i=1;i<K;i++){
            int k=i+1;  //表示此时数组分为几组
            for(int j=1;j<=length;j++){
                dp[i][j]=dp[i-1][j];
                for(int l=0;l<j;l++){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][l]+(sum[j]-sum[l])*1.0/(j-l));
                }
            }
        }
        return dp[K-1][length];
        // Write your code here
    }
}
