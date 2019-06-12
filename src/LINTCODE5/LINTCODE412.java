package LINTCODE5;

public class LINTCODE412 {
    /*Description
    * 有 N 个小孩站成一列。每个小孩有一个评级。给定数组 ratings 代表这些小孩的评级
    * 现在你需要按照以下要求，给小孩们分糖果：
    * 每个小孩至少得到一颗糖果。
    * 评级越高的小孩可以比他相邻的两个小孩得到更多的糖果。
    * 你最少要准备多少糖果？
    * */

    /*Solution
    * 每个小孩需要比他左右两边评分低于自己的人糖果数都多，因此我们需要从左到右以及从右到左两次遍历这个数组
    * */

    public int candy(int[] ratings) {

        int[] dp=new int[ratings.length];
        for(int i=0;i<dp.length;i++)
            dp[i]=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1])
                dp[i]=dp[i-1]+1;
        }
        for(int i=dp.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1])
                dp[i]=Math.max(dp[i+1]+1,dp[i]);
        }
        int result=0;
        for(int num:dp)
            result+=num;
        return result;
        // write your code here
    }
}
