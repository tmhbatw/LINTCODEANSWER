package LINTCODE2;

public class LINTCODE117 {
    /*Description
     *给出一个非负整数数组，你最初定位在数组的第一个位置。
     * 数组中的每个元素代表你在那个位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * */

    /*Solution
     * 动态规划，创建一个dp数组用来保存跳跃到当前节点的最小跳跃次数
     *
     * */

    public int jump(int[] A) {
        int[] dp=new int[A.length];
        for(int i=1;i<dp.length;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<A.length;i++){
            for(int j=1;j<=A[i]&&i+j<A.length;j++){
                dp[i+j]=Math.min(dp[i+j],dp[i]+1);
            }
        }
        return dp[dp.length-1];
        // write your code here
    }
}
