package LINTCODE8;

public class LINTCODE782 {
    /*Description
    *给 n 个非负整数，请你求出最大或和，最小或和，最大与和，最小与和这四个数之和。
    * */

    /*Description
    * Max And:最大的数
    * Min And:所有数And操作
    * Max Or:所有数Or操作
    * Min Or:最小的数
    * */

    public long getSum(int n, int[] nums) {
        if(n==0)
            return 0;
        int maxAnd=nums[0];
        int minAnd=nums[0];
        int maxOr=nums[0];
        int minOr=nums[0];
        for(int cur:nums){
            maxAnd=Math.max(maxAnd,cur);
            minAnd&=cur;
            maxOr|=cur;
            minOr=Math.min(minOr,cur);
        }
        long result=0;
        result=maxAnd+minAnd+maxOr+minOr;
        return result;
        // write your code here
    }
}
