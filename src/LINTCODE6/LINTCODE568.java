package LINTCODE6;

public class LINTCODE568 {
    /*Description
    * 给出一个整数数组，所有的元素都在 [−10,10],[−10,10] 之间。
    * 你有三次机会将数组中的一个数替换成任意数。
    * 请求出可能的最长相等子段数列的长度。
    * */

    public int threeChances(int[] nums) {
        int[] dp=new int[21];
        int right=-1;
        int length=nums.length;
        int result=0;
        for(int i=0;i<length;i++){
            while(right<length-1&&(isMatch(dp,nums[right+1]))){
                right++;
            }
            result=Math.max(result,right-i+1);
            dp[nums[i]+10]--;
        }
        return result;
        // write your code here.
    }

    private boolean isMatch(int[] dp,int next){
        dp[next+10]++;
        int max=0;
        int sum=0;
        for(int cur:dp){
            max=Math.max(max,cur);
            sum+=cur;
        }
        if(sum-max>3){
            dp[next+10]--;
            return false;
        }
        return true;
    }
}
