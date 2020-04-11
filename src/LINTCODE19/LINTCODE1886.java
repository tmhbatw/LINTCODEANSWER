package LINTCODE19;

public class LINTCODE1886 {
    /*Description
    *给定一个数组 nums 以及一个整数 target 。
    * 你需要把数组中等于target的元素移动到数组的最前面，并且其余的元素相对顺序不变。
    * 你的所有移动操作都应该在原数组上面操作。
    * */

    public void MoveTarget(int[] nums, int target) {
        int start=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                nums[i]=nums[start];
                nums[start++]=target;
                for(int j=start;j<i;j++){
                    swap(nums,j,i);
                }
            }
        }
        // write your code here
    }

    private void swap(int[] nums,int index1,int index2){
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }
}
