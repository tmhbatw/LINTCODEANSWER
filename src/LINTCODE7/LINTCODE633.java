package LINTCODE7;

import java.util.Arrays;

public class LINTCODE633 {
    /*Description
    *给出一个数组 nums 包含 n + 1 个整数，每个整数是从 1 到 n (包括边界)，
    * 保证至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
    * */

    public static  int findDuplicate(int[] nums) {
        System.out.println(nums.length);
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==nums[i+1])
                return nums[i];
        }
        return -1;
        // write your code here
    }

    public  static void main(String[] args){
        System.out.println(findDuplicate(new int[]{85,42,42,42,51,17,42,42,40,99,75,42,42,12,87,42,92,30,42,42,42,42,39,86,42,22,49,53,42,42,42,42,33,1,21,65,70,9,88,46,42,42,81,15,68,42,26,67,34,31,82,42,5,42,50,66,58,42,42,57,42,42,42,16,42,42,42,42,20,23,42,42,79,89,45,28,42,42,7,42,13,83,74,42,42,69,43,27,71,10,42,72,42,42,78,98,11,25,42,2}));
    }
}
