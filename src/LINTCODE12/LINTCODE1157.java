package LINTCODE12;

import java.util.*;

public class LINTCODE1157 {
    /*Description
    * 给定一个整数数组，你需要找到一个连续子数组，如果你只按升序对这个子数组进行排序，那么整个数组也将按升序排序。
    * 你需要找到最短的这样的子数组并输出它的长度。
    * */

    public int findUnsortedSubarray(int[] nums) {
        int[] num=new int[nums.length];
        for(int i=0;i<nums.length;i++)
            num[i]=nums[i];
        Arrays.sort(nums);
        int start=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=num[i]){
                start=i;
                break;
            }
        }
        if(start==-1)
            return 0;
        int end=-1;
        for(int j=nums.length-1;j>=0;j--){
            if(nums[j]!=num[j]){
                end=j;
                break;
            }
        }
        System.out.println(end+" "+start);
        return end-start;
        // Write your code here
    }
}
