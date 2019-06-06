package LINTCODE2;

import java.util.ArrayList;
import java.util.Arrays;

public class LINTCODE191 {

    /*Description
    * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
    * */

    /*Solution
    * 动态规划，创建两个数组，一个用来保存包含当前数字的最大的数，一个用来保存包含当前数字的最小的数（用来处理负数情况）
    * */

    public int maxProduct(int[] nums) {

        int[] max=new int[nums.length+1];
        max[0]=1;
        int[] min=new int[nums.length+1];
        min[0]=1;
        int result=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(max[i]==0){
                max[i+1]=nums[i];
                min[i+1]=nums[i];
                continue;
            }
            if(nums[i]>0){
                if(max[i]<0) {
                    max[i + 1] = nums[i];
                }else{
                    max[i+1]=max[i]*nums[i];
                }
                if(min[i]<1){
                    min[i+1]=min[i]*nums[i];
                }else{
                    min[i+1]=nums[i];
                }
            }else {
                if(min[i]<1){
                    max[i+1]=min[i]*nums[i];
                }else{
                    max[i+1]=nums[i];
                }
                if(max[i]<1){
                    min[i+1]=nums[i];
                }else{
                    min[i+1]=nums[i]*max[i];
                }
            }
            result=Math.max(result,Math.max(max[i+1],min[i+1]));
        }
        System.out.println(Arrays.toString(max));
        System.out.println(Arrays.toString(min));
        return result;
        // write your code here
    }
}
