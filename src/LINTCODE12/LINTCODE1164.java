package LINTCODE12;

public class LINTCODE1164 {
    /*Description
    *如果连续数字之间的差严格地在正和负之间交替，则这样的数字序列称为摆动序列。 第一个差值（如果存在）可以是正的也可以是负的。 少于两个元素的序列通常是摆动序列。
    * 例如，[1,7,4,9,2,5]是一个摆动序列，因为连续数字的差(6,-3,5,-7,3)交替为正和负。 相反，[1,4,7,2,5]和[1,7,4,5,5]不是摆动序列，
    * 第一个是因为它的前两个连续数字的差是正的，而第二个是因为它的最后一个连续数字的差零。
    * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些元素（和0）来获得子序列，使剩余元素保持其原始顺序。
    * */

    public int wiggleMaxLength(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int length=nums.length;
        int[] up=new int[length];
        int[] down=new int[length];
        up[0]=1;
        down[0]=1;
        for(int i=1;i<length;i++){
            if(nums[i]==nums[i-1]){
                up[i]=up[i-1];
                down[i]=down[i-1];
            }else if(nums[i]>nums[i-1]){
                up[i]=down[i-1]+1;
                down[i]=up[i-1];
            }else{
                up[i]=up[i-1];
                down[i]=up[i-1]+1;
            }
        }
        return Math.max(up[length-1],down[length-1]);

        // Write your code here
    }
}
