package LINTCODE13;

public class LINTCODE1201 {
    /*Description
    * 给定一个环形数组（最后一个元素的下一个元素是数组的第一个元素），为每个元素打印下一个更大的元素。
    * 数字x的下一个更大的数是数组中下一个遍历顺序中出现的第一个更大的数字，这意味着您可以循环搜索以查找其下一个更大的数字。 如果它不存在，则为此数字输出-1。
    * */

    public int[] nextGreaterElements(int[] nums) {
        int[] result=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            result[i]=-1;
            for(int j=1;j<nums.length;j++){
                int jj=(i+j)%nums.length;
                if(nums[jj]>nums[i]) {
                    result[i] = nums[jj];
                    break;
                }
            }
        }
        return result;
        // Write your code here
    }
}
