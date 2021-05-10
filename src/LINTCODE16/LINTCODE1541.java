package LINTCODE16;

public class LINTCODE1541 {
    /*Description
    * 现在有一些盒子以及一些位置，给两个数组分别代表盒子的高度以及位置的高度。如果盒子的高度不超过位置的高度，
    * 那么这个盒子就可以放进这个位置里面，一个位置只能存放一个盒子。你需要按顺序把盒子放入位置中，最多可以放入多少个盒子。
    * */

    public int putBox(int[] box, int[] position) {
        int[][] dp=new int[box.length+1][position.length+1];
        for(int i=0;i<box.length;i++){
            for(int j=0;j<position.length;j++){
                if(box[i]<=position[j])
                    dp[i+1][j+1]=dp[i][j]+1;
                else
                    dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
            }
        }
        return dp[box.length][position.length];
        // Write your code here
    }
}
