package LINTCODE14;

public class LINTCODE1310 {
    /*Description
    *给定n个整数的数组nums，其中n> 1，返回一个数组输出，使得output [i]等于nums的所有除了nums [i]的元素的乘积。
    * */

    public int[] productExceptSelf(int[] nums) {
        int[] result=new int[nums.length];
        result[0]=1;
        for(int i=1;i<nums.length;i++){
            result[i]=result[i-1]*nums[i-1];
        }
        int lastProduct=1;
        for(int i=nums.length-2;i>=0;i--) {
            lastProduct*=nums[i+1];
            result[i]*=lastProduct;
        }
        return result;
    }
}
