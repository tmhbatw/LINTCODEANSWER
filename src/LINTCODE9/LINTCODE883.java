package LINTCODE9;

public class LINTCODE883 {
    /*Description
    * 给出一个二进制数组，在最多翻转一位0的情况下，找到这个数组里最长的连续的1的个数。
    * */

    public int findMaxConsecutiveOnes(int[] nums) {
        int index=-1;
        int pre=-1;
        int result=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(index==-1)
                    index=i;
                else{
                    result=Math.max(result,i-pre-1);
                    pre=index;
                    index=i;
                }
            }
        }
        return Math.max(result,nums.length-pre-1);
        // write your code here
    }
}
