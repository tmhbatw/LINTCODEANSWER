package LINTCODE5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LINTCODE403 {
    /*Description
    * 给定一个整数循环数组（头尾相接），请找出一个连续的子数组，使得该子数组的和最大。输出答案时，请分别返回第一个数字和最后一个数字的值。
    * 如果多个答案，请返回其中任意一个。
    * */


    public List<Integer> continuousSubarraySumII(int[] A) {
        if(A.length==0){
            List<Integer> result=new ArrayList<>();
            result.add(0);
            result.add(0);
            return result;
        }
        int[] res=new int[2];
        int length=A.length;
        Deque<int[]> dq=new ArrayDeque<>();
        dq.add(new int[]{0,-1});
        int curSum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<length*2;i++){
            int idx=i;
            if(idx>=length) {
                idx -= length;
                if(-dq.peekFirst()[1]+i==length+1)
                    dq.pollFirst();
            }
            curSum+=A[idx];
            if(curSum-dq.peekFirst()[0]>max){
                max=curSum-dq.peekFirst()[0];
                res[0]=dq.peekFirst()[1];
                res[1]=i;
            }
            while(!dq.isEmpty()&&dq.peekLast()[0]>curSum)
                dq.pollLast();
            dq.add(new int[]{curSum,i});
        }
        res[0]++;
        List<Integer> result=new ArrayList<>();
        result.add(res[0]>=length?res[0]-length:res[0]);
        result.add(res[1]>=length?res[1]-length:res[1]);
        return result;
        // write your code here
    }

    public static void main(String[] args){
        Deque<Integer> dq=new ArrayDeque<>();
        dq.add(1);
        dq.add(2);
        System.out.println(dq);
        System.out.println(dq.peekFirst());
    }
}
