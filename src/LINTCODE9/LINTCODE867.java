package LINTCODE9;

public class LINTCODE867 {
    /*Description
    * 假设你有一个特殊的键盘，键盘上有如下键:
    * 键1: (A): 在屏幕上打印一个'A'。
    * 键2: (Ctrl-A): 选择整个屏幕。
    * 键3: (Ctrl-C): 复制选择到缓冲区。
    * 键4: (Ctrl-V): 在屏幕上已有的内容后面追加打印缓冲区的内容。
    * 现在，你只能按键盘上N次(使用以上四个键)，找出你可以在屏幕上打印的“A”的最大数量
    * */

    public int maxA(int N) {
        if(N<=6)
            return N;
        int[] dp=new int[N+1];
        dp[1]=1;
        for(int i=2;i<=N;i++){
            dp[i]=dp[i-1]+1;
            for(int j=0;j<=i-3;j++){
                dp[i]=Math.max(dp[i],dp[j]*(i-j-1));
            }
        }
        return dp[N];
        // write your code here
    }
}
