package LINTCODE10;

import java.util.Arrays;

public class LINTCODE906 {
    /*Description
    * 给定一个已排序的整数数组和整数a,b,c。对数组中的每个元素xx应用二次函数f(x)=ax^2+bx+cf(x)=ax2+bx+c。
    * 返回的数组必须是有序的。
    * */

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        for(int i=0;i<nums.length;i++){
            nums[i]=getRes(nums[i],a,b,c);
        }
        Arrays.sort(nums);
        return nums;
        // Write your code here
    }

    private int getRes(int cur,int a ,int b, int c){
        return a*cur*cur+b*cur+c;
    }
}
