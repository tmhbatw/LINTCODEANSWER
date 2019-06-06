package LINTCODE2;

public class LINTCODE196 {
    /*Description
    * Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.
    * */

    /*Solution
    * 我们知道从0到n数字之和是多少，减去数列中的每一个数就是缺失的那一个数
    * */

    public int findMissing(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            result+=i+1-nums[i];
        }
        return result;
        // write your code here
    }

}
