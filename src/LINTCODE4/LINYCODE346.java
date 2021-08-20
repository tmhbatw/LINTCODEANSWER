package LINTCODE4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LINYCODE346 {
    /*Description
    * 给你一个数组，请计算出所有子区间的最大值异或最小值的异或
    * */

    public int XorSum(int[] nums) {
        int length=nums.length;
        int[] bigLeft=new int[length];
        int[] bigRight=new int[length];
        Stack<int[]> q=new Stack<>();
        q.add(new int[]{Integer.MAX_VALUE,-1});
        for(int i=0;i<length;i++){
            while(q.peek()[0]<=nums[i]){
                int[] cur=q.pop();
                bigRight[cur[1]]=i;
            }
            bigLeft[i]=q.peek()[1];
            q.add(new int[]{nums[i],i});

        }
        while(!q.isEmpty()){
            int[] cur=q.pop();
            if(cur[0]<Integer.MAX_VALUE)
                bigRight[cur[1]]=length;
        }
        int[] smallLeft=new int[length];
        int[] smallRight=new int[length];
        q.add(new int[]{Integer.MIN_VALUE,-1});
        for(int i=0;i<length;i++){
            while(q.peek()[0]>=nums[i]){
                int[] cur=q.pop();
                smallRight[cur[1]]=i;
            }
            smallLeft[i]=q.peek()[1];
            q.add(new int[]{nums[i],i});
        }
        while(!q.isEmpty()){
            int[] cur=q.pop();
            if(cur[0]>Integer.MIN_VALUE)
                smallRight[cur[1]]=length;
        }

        int result=0;
        for(int i=0;i<length;i++){
            long time= (long) (i - smallLeft[i]) *(smallRight[i]-i)+ (long) (i - bigLeft[i]) *(bigRight[i]-i);
            if(time%2==1)
                result^=nums[i];
        }
        return result;
        //  write your code here
    }

    public static void main(String[] args){
        int[] num=new int[]{1,3,2};
        System.out.println(new LINYCODE346().XorSum(num));
    }


}
