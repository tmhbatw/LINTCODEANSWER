package LINTCODE12;

import java.util.List;

public class LINTCODE1168 {
    /*Description
    * 有一个数组numsnums，以及三个正整数k,u,l
    * 对于numsnums的所有长为k的子段，如果它的总和小于u，就得1分，如果它的总和大于l，就扣1分。
    * 请求出最终能获得多少分？
    * */

    public int arrayScore(List<Integer> nums, int k, long u, long l) {
        if(k>nums.size())
            return 0;
        long curSum=0;
        for(int i=0;i<k-1;i++)
            curSum+=nums.get(i);
        int result=0;
        for(int i=k-1;i<nums.size();i++){
            curSum+=nums.get(i);
            if(curSum<u)
                result++;
            if(curSum>l)
                result--;
            curSum-=nums.get(i-k+1);
        }
        return result;
        // write your code here.
    }
}
