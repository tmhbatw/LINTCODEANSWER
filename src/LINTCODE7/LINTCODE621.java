package LINTCODE7;

import java.util.*;

public class LINTCODE621 {
    /*Description
    * 给定一个整数数组，找到长度在 k1 与 k2 之间(包括 k1, k2)的子数组并且使它们的和最大，
    * 返回这个最大值，如果数组元素个数小于 k1 则返回 0
    * */

    public int maxSubarray5(int[] nums, int k1, int k2) {
        if(nums.length<k1)
            return 0;
        int length=nums.length;
        long[] sum=new long[length];
        sum[0] = nums[0];
        for(int i=1;i<k1-1;i++)
            sum[i]+=sum[i-1]+nums[i];
        long res=Integer.MIN_VALUE;
        Deque<Long[]> q=new ArrayDeque<>();
        q.add(new Long[]{0L,-1L});
        for(int i=k1-1;i<length;i++){
            if(i>0)
                sum[i]+=sum[i-1]+nums[i];
            else
                sum[0] = nums[0];
            res =  Math.max(sum[i]-q.peek()[0],res);
            int addIndex = i-k1+1;
            while(!q.isEmpty()&&q.peekLast()[0]>=sum[addIndex])
                q.pollLast();
            q.add(new Long[]{ sum[addIndex],(long)addIndex});
            int removeIndex = i-k2+1;
            if(q.peekFirst()[1]<removeIndex)
                q.pollFirst();

        }
        return (int)res;
        // write your code here
    }

}
