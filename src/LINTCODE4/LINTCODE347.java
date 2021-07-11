package LINTCODE4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LINTCODE347 {
    /*Description
    * 小强得到了长度为n的序列，但他只对非常大的数字感兴趣，因此随机选择这个序列的一个连续子序列，
    * 并求这个序列的最大值，请告诉他这个最大值的期望是多少。
    * */

    public double expectMaximum(int[] nums) {
        double res = 0;
        int length = nums.length;
        long base = (long)(length+1)*length/2;
        Stack<int[]> q=new Stack<>();
        q.add(new int[]{Integer.MAX_VALUE,-1});
        for(int i=0;i<length;i++){
            while(q.peek()[0]<=nums[i]){
                int[] cur=q.pop();
                int left=cur[1]-q.peek()[1];
                int right=i-cur[1];
                res += (double) left *right*cur[0];
            }
            q.add(new int[]{nums[i],i});
        }
        while(!q.isEmpty()) {
            int[] cur= q.pop();
            if(cur[0]==Integer.MAX_VALUE)
                break;
            int right=length-cur[1];
            int left = cur[1]-q.peek()[1];
            res += (double) left*right*cur[0];
        }
        return res/base;
        // write your code here
    }

    public static void main(String[] args){
        int[] num = new int[]{2,3,2};
        System.out.println(new LINTCODE347().expectMaximum(num));
    }
}
