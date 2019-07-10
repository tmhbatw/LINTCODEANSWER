package LINTCODE6;

import java.util.Arrays;

public class LINTCODE507 {
    /*Description
    * Given an unsorted array nums, reorder it such that
    * nums[0] < nums[1] > nums[2] < nums[3]....
    * */
    /*Solution
    * 与508题相似
    * 排序后交叉摆放
    * */

    public void wiggleSort(int[] nums) {
        // write your code here
        int[] temp = (int[])nums.clone();
        Arrays.sort(temp);
        int n = nums.length;
        int left = (n-1)/2;
        int right = n-1;

        int index = 0;
        while(left>=0 && right>=(n+1)/2) {
            nums[index++] = temp[left--];
            nums[index++] = temp[right--];
        }
        if(left>=0) {
            nums[index] = temp[left];
        }
    }
}
