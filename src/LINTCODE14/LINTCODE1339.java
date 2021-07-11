package LINTCODE14;

import java.util.Stack;

public class LINTCODE1339 {
    /*Description
    * 给定一个非负数的整数数组，需要选出一个区间, 使得该区间是所有区间中值最大的一个，
    * 我们定义一个区间的值为：区间中的最小数 * 区间所有数的和。
    * */

    public int maxRange(int[] nums) {
        Stack<int[]> stack=new Stack<>();
        stack.add(new int[]{Integer.MIN_VALUE,-1});
        int res=Integer.MIN_VALUE;
        int length=nums.length;
        int[] sum=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            sum[i+1]=sum[i]+nums[i];
            while(stack.peek()[0]>=nums[i]){
                int[] cur=stack.pop();
                int s=sum[i]-sum[stack.peek()[1]+1];
                res=Math.max(res,s*cur[0]);
            }
            stack.add(new int[]{nums[i],i});
        }
        while(!stack.isEmpty()){
            int[] cur=stack.pop();
            if(cur[0]==Integer.MIN_VALUE)
                break;
            res=Math.max(res,(sum[length]-sum[stack.peek()[1]+1])*(cur[0]));
        }
        return res;
        // write your code here
    }
}
