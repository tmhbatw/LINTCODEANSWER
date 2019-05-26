package LINTCODE;

import java.util.Arrays;
import java.util.Collections;

public class LINTCODE52 {
    /*Description
    * 给定一个整数数组来表示排列，找出其之后的一个排列
    * */

    /*Solution
    * 与上一题思路基本相同，具体操作相反
    * */
    public int[] nextPermutation(int[] nums) {
        if(nums.length<=1)
            return nums;
        int index=nums.length-2;
        while(index>=0&&nums[index]>=nums[index+1])
            index--;
        return reorder(nums,index);
        // write your code here
    }

    private int[] reorder(int[]nums,int index){
        if(index==-1){
            for(int i=0,j=nums.length-1;i<j;i++,j--){
                int curr=nums[i];
                nums[i]=nums[j];
                nums[j]=curr;
            }
            return nums;
        }else{
            int curr=nums[index];
            for(int i=nums.length-1;i>index;i--){
                if(nums[i]>curr){
                    nums[index]=nums[i];
                    nums[i]=curr;
                    break;
                }
            }
            Arrays.sort(nums,index+1,nums.length);
            return nums;
        }
    }

    public static void main(String[] args){
        int[] nums={5,2,4,3};
        Arrays.sort(nums,1,4);
        System.out.println(Arrays.toString(nums));
    }
}
