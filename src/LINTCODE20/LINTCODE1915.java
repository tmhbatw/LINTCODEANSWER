package LINTCODE20;

public class LINTCODE1915 {
    /*Description
    *奥利刚来到健身房，她正在计算她能举起的最大重量。
    * 杠铃所能承受的最大重量为maxCapacily，健身房里有n个杠铃片，第 i 个杠铃片的重量为 weights[i]。
    * 奥利现在需要选一些杠铃片加到杠铃上，使得杠铃的重量最大，但是所选的杠铃片重量总和又不能超过 maxCapacity ，请计算杠铃的最大重量是多少。
    * 比如，给定杠铃片的重量为 weights = [1, 3, 5]， 而杠铃的最大承重为 maxCapacily = 7，那么应该选择重量为 1 和 5 的杠铃片，
    * (1 + 5 = 6)，所以最终的答案是 6。
    * */

    public int weightCapacity(int[] weights, int maxCapacity) {
        int[] dp=new int[maxCapacity+1];
        for(int i=0;i<weights.length;i++){
            int curWeight=weights[i];
            for(int j=maxCapacity;j>=0;j--){
                if(j>=curWeight){
                    dp[j]=Math.max(dp[j],dp[j-curWeight]+curWeight);
                }
            }
        }
        return dp[maxCapacity];
        // Write your code here
    }
}
