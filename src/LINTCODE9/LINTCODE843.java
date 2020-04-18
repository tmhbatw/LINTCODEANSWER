package LINTCODE9;

import java.util.Arrays;

public class LINTCODE843 {
    /*Description
    *给定一个01构成的数组。你可以翻转1变成0或者反转0变成1。
    * 请问最少反转多少次可以使得数组满足以下规则：
    * 1的后面可以是1或者0，而0的后面必须是0。
    * */

    public int flipDigit(int[] nums) {
        int number=nums.length;
        int[] time=new int[number+1];
        for(int i=number-1;i>=0;i--){
            time[i]=time[i+1]+(nums[i]==1?1:0);
        }
        System.out.println(Arrays.toString(time));
        int time0=0;
        int result=time[0];
        for(int i=0;i<number;i++){
            if(nums[i]==0)
                time0++;
            result=Math.min(result,time0+time[i+1]);
        }
        return result;
        // Write your code here
    }

}
