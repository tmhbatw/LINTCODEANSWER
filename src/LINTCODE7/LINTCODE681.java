package LINTCODE7;

import java.util.Arrays;

public class LINTCODE681 {
    /*Description
    * 给一个素数数组，找到最小的未出现的素数
    * */

    public int firstMissingPrime(int[] nums) {
        Arrays.sort(nums);
        int start=2;
        for(int num:nums){
            if(num==start)
                start=getPrime(start);
            else
                return start;
        }
        return start;
        // write your code here
    }

    private int getPrime(int start){
        if(start==2)
            return 3;
        while(true){
            start+=2;
            int end= (int) Math.sqrt(start);
            for(int i=2;i<=end;i++){
                if(start%i==0)
                    break;
                if(i==end)
                    return start;
            }
        }

    }
}
