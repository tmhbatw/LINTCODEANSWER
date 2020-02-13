package LINTCODE19;

public class LINTCODE1816 {
    /*Description
    *给你一个整数数组 nums 和一个正整数 threshold  ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。
    * 你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。
    * 每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。
    * 题目保证一定有解。
    * */

    public int smallestDivisor(int[] nums, int threshold) {
        int index=1;
        int left=0;
        int right=Integer.MAX_VALUE;
        while(right>left){
            int mid=left+(right-left)/2;
            if(getResult(mid,nums)>threshold){
                left=mid+1;
            }
            else
                right=mid;
        }
        return right;
        // write your code here
    }

    private int getResult(int cur,int[] nums){
        int result=0;
        for(int curr:nums){
            result+=(curr-1)/cur+1;
        }
        return result;
    }
}
