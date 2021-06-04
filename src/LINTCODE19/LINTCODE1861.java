package LINTCODE19;

public class LINTCODE1861 {
    /*Description
    * 有一个老鼠从高为n的楼梯顶部跳跃下来，这个老鼠在偶数次跳跃时可以跳1, 3或者4个台阶，奇数次可以跳跃1,
    * 2或者4个台阶。但是楼梯中间会有一些台阶上有胶水，如果跳到那些台阶上，老鼠就会被直接粘住，无法继续跳跃。
    * 你需要求出从这个楼梯顶部开始，老鼠有多少种方法能够到达地面，即第0层。若超过地面，也算是可以到达。例如从1跳跃到-1，
    * 和从1跳跃到0的方案不同。楼梯有无胶水的状态是从高往低输入的，即arr[0]为楼梯的顶部。
    * 其中，arr[i] == 0代表当前老鼠所在的位置无胶水，arr[i] == 1代表当前老鼠所在的位置有胶水。
    * */

    public int ratJump(int[] arr) {
        int length=arr.length-1;
        int[][] dp=new int[length+1][2];
        int[] evenStep=new int[]{1,3,4};
        int[] countStep=new int[]{1,2,4};
        dp[0][0]=1;
        int mod=1000000007;
        for(int i=0;i<length;i++){
            for (int j : countStep){
                int nextStep = Math.min(length, i+j);
                dp[nextStep][1]=(dp[nextStep][1]+dp[i][0])%mod;
            }
            for(int j : evenStep){
                int nextStep = Math.min(length,i+j);
                dp[nextStep][0]=(dp[nextStep][0]+dp[i][1])%mod;
            }
        }
        return (dp[length][0]+dp[length][1])%mod;
        // Write your code here.
    }

}
