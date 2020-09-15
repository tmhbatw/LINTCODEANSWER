package LINTCODE11;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1021 {
    /*Description
    * 给定一个包含正整数的数组A , 以及两个正整数 L 和R (L <= R).
    * 返回最大元素值在范围[L, R]之间的子数组(连续, 非空)的个数,
    * */

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        Queue<Integer> q1=new LinkedList<>(); //用来存储比R大的数字的索引
        Queue<Integer> q2=new LinkedList<>(); //用来存储范围内的数字索引
        int length=A.length;
        for(int i=0;i<length;i++){
            if(A[i]>R)
                q1.add(i);
            else if(A[i]>=L&&A[i]<=R)
                q2.add(i);
        }
        int result=0;
        for(int i=0;i<length;i++){
            if(A[i]>R) {
                q1.poll();
            }
            else if(A[i]<=R&&A[i]>=L){
                result+=(q1.isEmpty()?length:q1.peek())-i;
                q2.poll();
            }else{
                if(!q2.isEmpty()){
                    if(q1.isEmpty())
                        result+=length-q2.peek();
                    else
                        result+=Math.max(0,q1.peek()-q2.peek());
                }
            }
        }
        return result;
        // Write your code here
    }

}
