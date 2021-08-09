package LINTCODE16;

public class LINTCODE1556 {
    /*Description
    * 为了进一步宣传，Lintcode决定策划一个猜数游戏。 游戏开始前，Lintcode会随机保密地选择一个不大于n的正整数x
    * 让玩家来猜，并提供一个长度为n的数组a，a[i]表示玩家选择整数i时需要付出的金钱。 每一轮游戏，玩家可以任意选择一个整数并付出相应的价钱，
    * 如果猜中了，即选择的数是x，则游戏结束，否则Lintcode的小姐姐会告诉玩家x比玩家所选择的数大或者小，随后玩家继续付钱选择下一个数，直
    * 到猜中x为止。游戏结束后，最后一轮猜数所付出的金钱a[x]将会被返还给玩家。 猜数的策略多种多样，而同一种策略当x为不同的数时
    * 需要付出的金钱也不一样。问能否找到一种最优策略，在最坏的情况下猜中数需要付出的代价最小？输出最小的代价。
    * */

    public int getAnswer(int[] a) {
        int length=a.length;
        int[][] dp=new int[length][length];
        for(int l=1;l<a.length;l++){
            for(int i=0;i<length-l;i++){
                int j=i+l;
                dp[i][j]=Math.min(dp[i+1][j]+a[i],dp[i][j-1]+a[j]);
                for(int k=i+1;k<j;k++){
                    dp[i][j]=Math.min(dp[i][j],a[k]+Math.max(dp[i][k-1],dp[k+1][j]));
                }
            }
        }
        return dp[0][a.length-1];
        // Write your code here
    }

    public static void main(String[] args){
        int[] num=new int[]{1,3,5,1,1,8,4};
        System.out.println(new LINTCODE1556().getAnswer(num));
    }
}
