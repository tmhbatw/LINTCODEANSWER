package LINTCODE11;

import java.util.Arrays;

public class LINTCODE1099 {
    /*Description
    * 给定一个包含 n 个整数的数组，你的任务是检测在改变至多一个元素的情况下，它是否可以变成不下降的。
    * 我们定义一个数组是不下降的，如果 array[i] <= array[i + 1] 对于每一个 i (1 <= i < n) 都成立。
    * */


    public boolean checkPossibility(int[] nums) {
        boolean flag=false;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                if(flag)
                    return false;
                else{
                    flag=true;
                    if(i==1) {
                        nums[i-1]=nums[i];
                        continue;
                    }
                    if(nums[i]<nums[i-2])
                        nums[i]=nums[i-1];
                    else
                        nums[i-1]=nums[i];
                }
            }
        }
        return true;
        // Write your code here
    }
}
