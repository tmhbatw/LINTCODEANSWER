package LINTCODE11;

import java.util.Arrays;

public class LINTCODE1093 {
    /*Description
    * 给定一个无序的整数序列，找到最长的升序子序列的个数。
    * */

    public int findNumberOfLIS(int[] nums) {
        int length=nums.length;
        int[] l=new int[length];
        int[] num=new int[length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(l[i]==l[j]+1){
                        num[i]+=num[j];
                    }else if(l[i]<l[j]+1){
                        l[i]=l[j]+1;
                        num[i]=num[j];
                    }
                }
            }
            if(l[i]==0){
                l[i]=1;
                num[i]=1;
            }
        }
        int result=0;
        int maxLength=0;
        for(int i=0;i<length;i++){
            if(l[i]>maxLength){
                maxLength=l[i];
                result=num[i];
            }else if(l[i]==maxLength){
                result+=num[i];
            }
        }
        System.out.println(Arrays.toString(l));
        System.out.println(Arrays.toString(num));
        return result;
        // Write your code here
    }
}
