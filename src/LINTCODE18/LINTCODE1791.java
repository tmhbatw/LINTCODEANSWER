package LINTCODE18;

import java.util.Arrays;

public class LINTCODE1791 {
    /*Description
    *对于两个数组，第一个数组可能包含可重复的整数。返回的数组的长度与第二个数组相同。
    * 对于第二个数组中的每个元素a，第一个数组中有多少个数字<=a。
    * */

    public int[] SimpleQueries (int[] nums, int[] sub) {
        if(nums.length==0)
            return new int[sub.length];
        Arrays.sort(nums);
        int length=nums.length;
        int max=nums[length-1];
        int[] result=new int[sub.length];
        for(int i=0;i<sub.length;i++){
            int target=sub[i];
            if(target>max){
                result[i]=length;
                continue;
            }
            if(target<nums[0]){
                result[i]=0;
                continue;
            }
            result[i]=getNumber(target,nums)+1;
        }
        return result;
        // write your code here
    }

    private int getNumber(int target,int[] nums){
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<=target&&(mid==nums.length-1||nums[mid+1]>target))
                return mid;
            if(nums[mid]<=target)
                left=mid+1;
            else{
                right=mid-1;
            }
        }
        return left;
    }
}
