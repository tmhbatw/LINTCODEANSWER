package LINTCODE14;

public class LINTCODE1392 {
    /*Description
    * 我们有如下工作：difficulty[i]是第i个工作的难度，profit[i]是第i个工作的利润。
    * 现在我们有一些工人。 worker[i]是第i个工人的能力，这意味着这个工人最多完成难度为worker[i]的工作。
    * 每个工人最多只能分配一份工作，但一份工作可以多次完成。
    * 例如，如果3个人尝试完成1美元的相同工作，那么总利润将为3美元。 如果工人无法完成任何工作，他的利润为0美元。
    * 我们可以获得的利润最大是多少？
    * */

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int max=0;
        for(int cur:difficulty)
            max=Math.max(cur,max);
        int[] dp=new int[max+1];
        for(int i=0;i<difficulty.length;i++){
            dp[difficulty[i]]=Math.max(dp[difficulty[i]],profit[i]);
        }
        for(int i=1;i<=max;i++){
            dp[i]=Math.max(dp[i],dp[i-1]);
        }
        int result=0;
        for(int i=0;i<worker.length;i++){
            if(worker[i]>=max)
                result+=dp[max];
            else
                result+=dp[worker[i]];
        }
        return result;
        //
    }
}
