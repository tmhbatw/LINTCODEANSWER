package LINTCODE16;

public class LINTCODE1583 {
    /*Description
    *现在有一个游戏，给定一个包含n个整数的数列a，玩家可以进行若干次操作，每次操作可以选择一个元素a[k]，玩家获得a[k]的得分，
    * 同时需要从数列中删除一个a[k]和所有值等于a[k] + 1和a[k] - 1的数。直到数列中所有数被删除，游戏结束。现在玩家想要尽可能地获得最大的游戏分数，输出这个最大的分数。
    * */

    public int getAnswer(int[] a) {
        int max=Integer.MIN_VALUE;
        for(int num:a)
            max=Math.max(num,max);
        int[] dp=new int[max+1];
        for(int num:a)
            dp[num]+=num;
        for(int i=2;i<=max;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+dp[i]);
        }
        return dp[max];
        // Write your code here
    }
}
