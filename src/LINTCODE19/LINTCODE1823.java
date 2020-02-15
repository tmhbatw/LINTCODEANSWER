package LINTCODE19;

public class LINTCODE1823 {
    /*Description
    *给定两个正整数X和Y，以及正整数数组nums。
    * 我们需要找到一个最大的index，使得在nums[0], nums[1], .... , nums[index]中，
    * 出现X、Y的次数相等，且至少均出现一次，返回该index。
    * 若不存在这样的index，则返回-1。
    * */

    public int LongestPrefix(int X, int Y, int[] nums) {
        int timex=0;
        int timey=0;
        int result=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==X)
                timex++;
            if(nums[i]==Y)
                timey++;
            if(timex==timey&&timex!=0)
                result=i;
        }
        return result;
        // write your code here
    }
}
