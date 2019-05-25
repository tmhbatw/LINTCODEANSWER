package LINTCODE;

import java.util.List;

public class LINTCODE46 {
    /*Description
    *Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.
    * */

    /*Solution
    *使用摩尔投票法
    * 先将第一个数字假设为过半数，然后把计数器设为1，比较下一个数和此数是否相等，若相等则计数器加一，反之减一。然后看此时计数器的值，若为零，则将下一个值设为候选过半数。
    * 以此类推直到遍历完整个数组，当前候选过半数即为该数组的过半数
    * */

    public int majorityNumber(List<Integer> nums) {
        int result=nums.get(0);
        int count=1;
        for(int i=1;i<nums.size();i++){
            if(result==nums.get(i)){
                count++;
            }else{
                count--;
            }
            if(count==0)
                result=nums.get(i+1);
        }
        return result;
    }
}
