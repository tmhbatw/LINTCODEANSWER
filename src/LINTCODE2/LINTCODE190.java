package LINTCODE2;

import java.util.Arrays;

public class LINTCODE190 {

    /*Description
    *给定一个若干整数的排列，给出按正数大小进行字典序从小到大排序后的下一个排列。
    * 如果没有下一个排列，则输出字典序最小的序列。
    * */

    /*Solution
    * 从后开始往前找到第一个非降序的数列，进行交换数字位置(将当前数字与后面比他大且最小的数字进行交换，其他数字正常排序即可）
    * */

    public void nextPermutation(int[] nums) {
        if(nums.length<2)
            return ;
        int index=nums.length-2;
        while(index>=0&&nums[index]>=nums[index+1]){
            index--;
        }
        if(index==-1){
            Arrays.sort(nums);
            return ;
        }
        else{
            for(int j=nums.length-1;j>index;j--){
                if(nums[j]>nums[index]){
                    int temp=nums[j];
                    nums[j]=nums[index];
                    nums[index]=temp;
                    break;
                }
            }
            Arrays.sort(nums,index+1,nums.length);
        }
        // write your code here
    }
}
