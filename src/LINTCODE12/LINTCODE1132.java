package LINTCODE12;

import java.util.Arrays;

public class LINTCODE1132 {
    /*Description
    *给定一个包含非负整数的数组，你的任务是计算从数组中选出的可以制作三角形的三元组数目，
    * 如果我们把它们作为三角形的边长。
    * */

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result=0;
        int length=nums.length;
        for(int i=0;i<length-2;i++){
            for(int j=i+1;j<length-1;j++){
                int curSum=nums[i]+nums[j];
                if(nums[j+1]>=curSum)
                    continue;
                int left=j+1,right=length-1;
                int mid=left+1;
                while(left<=right){
                    mid=left+(right-left)/2;
                    if(nums[mid]<curSum&&(mid==length-1||nums[mid+1]>=curSum))
                        break;
                    if(nums[mid]<curSum)
                        left=mid+1;
                    else
                        right=mid-1;
                }
                result+=mid-j;
            }
        }
        return result;
        // Write your code here
    }
}
