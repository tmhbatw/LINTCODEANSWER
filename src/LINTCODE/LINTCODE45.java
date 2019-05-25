package LINTCODE;

import java.util.Arrays;

public class LINTCODE45 {
    /*Description
    * 给定一个整数数组，找出两个不重叠的子数组A和B，使两个子数组和的差的绝对值|SUM(A) - SUM(B)|最大。返回这个最大的差值。
    * */

    /*Solution
    *从左到右遍历出一个最大和，从右到左遍历出一个最小的值，记录二者差值
    * 从左到右遍历出一个最小和，从右到左遍历出一个最大的值，记录二者差值
    * 返回二者之间最大值
    * */

    public int maxDiffSubArrays(int[] nums) {
        int[] left=new int[nums.length+2];
        int totalmax=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            left[i]=Math.max(left[i-1],0)+nums[i-1];
            totalmax=Math.max(totalmax,left[i]);
        }
        left[nums.length]=nums[nums.length-1];
        totalmax=Integer.MIN_VALUE;
        int totalmin=left[nums.length];
        for(int i=nums.length-2;i>=0;i--){
            totalmax=Math.max(totalmax,left[i+1]-totalmin);
            left[i+1]=Math.min(0,left[i+2])+nums[i];
            totalmin=Math.min(totalmin,left[i+1]);
        }
        System.out.println(totalmax);
        int[] right=new int[nums.length+2];
        totalmin=Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            right[i]=Math.min(right[i-1],0)+nums[i-1];
            totalmin=Math.min(totalmin,right[i]);
        }
        right[nums.length]=nums[nums.length-1];
        System.out.println(Arrays.toString(right));
        int currmax=right[nums.length];
        for(int i=nums.length-2;i>=0;i--){
            System.out.println((currmax));
            totalmax=Math.max(currmax-right[i+1],totalmax);
            System.out.println((totalmax));
            right[i+1]=Math.max(right[i+2],0)+nums[i];
            currmax=Math.max(right[i+1],currmax);
        }
        return totalmax;
        // write your code here
    }


}
