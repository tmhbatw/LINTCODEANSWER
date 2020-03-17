package LINTCODE7;

import java.util.Arrays;

public class LINTCODE606 {
    /*Description
    * 找到数组中第K大的元素，N远大于K。请注意你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
    * */

    public int kthLargestElement2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k-1];
        // write your code here
    }
}
