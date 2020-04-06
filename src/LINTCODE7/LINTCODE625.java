package LINTCODE7;

public class LINTCODE625 {
    /*Description
    * 将一个没有经过排序的整数数组划分为 3 部分:
    * 1.第一部分中所有的值都 < low
    * 2.第二部分中所有的值都 >= low并且 <= high
    * 3.第三部分中所有的值都 > high
    * 返回任意一种可能的情况。
    * */

    public void partition2(int[] nums, int low, int high) {
        int left=0,right=nums.length-1;
        int i=0;
        while(i<=right){
            if(nums[i]<low){
                swap(nums,i,left);
                i++;
                left++;
            }else if(nums[i]>high){
                swap(nums,i,right);
                right--;
            }else
                i++;
        }
        // write your code here
    }

    private void swap(int[] nums,int index1,int index2){
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }

}
