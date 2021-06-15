package LINTCODE11;

public class LINTCODE1009 {
    /*Description
    * 现在有两种汤：品种A与品种B。开始时我们每种汤都有 N ml。下面有四种操作：
    * 供应100毫升汤A和0毫升汤B
    * 供应75毫升汤A和25毫升汤B.
    * 供应50毫升汤A和50毫升汤B.
    * 供应25毫升汤A和75毫升汤B.
    * 当我们提供了某些汤，我们就会把汤给某个人并且不再拥有它。每一回合，我们会等概率的选择上述四种操作中的一种。
    * 如果剩余的汤量不足以完成操作，我们将尽可能多的提供。一旦我们不再有两种类型的汤，我们就会停止
    * 请注意，我们没有先供应所有100毫升汤B的操作。返回 汤A先为空的概率加上A和B同时变为空的概率的一半。
    * */

    public double soupServings(int N) {
        N = N/25+(N%25==0?1:0);
        if(N>=500)
            return 1;
        double[][] dp=new double[N+1][N+1];//i表示剩余的A，j表示剩余的B
        dp[0][0]=0.5;
        for(int j=1;j<=N;j++)
            dp[0][j]=1.0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                dp[i][j]=0.25*dp[Math.max(i-4,0)][j]+0.25*dp[Math.max(i-3,0)][j-1]
                        +0.25*dp[Math.max(i-2,0)][Math.max(j-2,0)]+0.25*dp[i-1][Math.max(j-3,0)];
            }
        }
        return dp[N][N];
        // Write your code here
    }
}
