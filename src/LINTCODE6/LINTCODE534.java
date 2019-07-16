package LINTCODE6;

public class LINTCODE534 {

    /*Description
    * 在上次打劫完一条街道之后，窃贼又发现了一个新的可以打劫的地方，但这次所有的房子围成了一个圈，这就意味着第一间房子和最后一间房子是挨着的。
    * 每个房子都存放着特定金额的钱。你面临的唯一约束条件是：相邻的房子装着相互联系的防盗系统，且 当相邻的两个房子同一天被打劫时，该系统会自动报警。
    * 给定一个非负整数列表，表示每个房子中存放的钱， 算一算，如果今晚去打劫，在不触动报警装置的情况下, 你最多可以得到多少钱 。
    * */

    /*Solution
    * 与第一题基本相同，只不过选择第一个房间偷窃意味着没有办法偷窃第一间房间
    * 选择最后一间房间意味着没有办法偷窃第一个房间
    * */

    public int houseRobber2(int[] nums) {
        if(nums.length==0)
            return 0;
        int[] dp=new int[nums.length+1];
        int max=nums[0];
        for(int i=0;i<nums.length-1;i++){
            dp[i+2]=Math.max(nums[i]+dp[i],dp[i+1]);
            max=Math.max(max,dp[i+2]);
        }
        for(int i=1;i<nums.length;i++){
            dp[i+1]=Math.max(nums[i]+dp[i-1],dp[i]);
            max=Math.max(max,dp[i+1]);
        }
        return max;
        // write your code here
    }
}
