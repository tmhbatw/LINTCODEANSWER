package LINTCODE18;

public class LINTCODE1753 {
    /*Description
    * n个人，他们每个人需要独立做m份作业。
    * 第i份作业需要花费cost[i]的时间。由于每个人的空闲时间不同，第i个人有val[i]的时间，这代表他做作业的总时间不会超过val[i]。
    * 每个人都按照顺序，从1号作业开始，然后做2号，3号...... 现在，你需要计算出他们最多花了多少的时间。
    * */

    public long doingHomework(int[] cost, int[] val) {
        int[] dp=new int[100001];
        int pre=0;
        for(int i=0;i<cost.length;i++){
            pre+=cost[i];
            if(pre>100001)
                break;
            dp[pre]=pre;
        }
        for(int i=1;i<100001;i++){
            dp[i]=Math.max(dp[i-1],dp[i]);
        }
        long result=0;
        for(int cur:val){
            result+=dp[cur];
        }
        return result;
        // Write your code here.
    }
}
