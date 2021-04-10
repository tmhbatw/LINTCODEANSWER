package LINTCODE16;

public class LINTCODE1529 {
    /*Description
    * 给定一个递增的整数数组nums，和一个表示限制的整数limit，请你返回满足条件的三元子数组的个数，
    * 使得该子数组中的任意两个元素之间的绝对差小于或者等于limit。
    * 如果不存在满足条件的子数组，则返回 0 。
    * */

    public int tripletSubarray(int[] nums, int limit) {
        int result=0;
        int right=0;
        int length=nums.length;
        for(int i=0;i<length;i++){
            while(right<length-1&&nums[right+1]-nums[i]<=limit)
                right++;
            if(right-i>=2)
                result+=getVal(right-i-1);
            System.out.println(result);
        }
        return result;
        // write your code here
    }

    private int getVal(int cur){
        return (1+cur)*cur/2;
    }
}
