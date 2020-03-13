package LINTCODE15;

import java.util.Stack;

public class LINTCODE1416 {
    /*Description
    * 给一个数组，对于每一个元素，找出它之前第一个比它小的元素的值。如果没有，则输出它本身。
    * */

    public int[] getPreviousNumber(int[] num) {
        Stack<Integer> stack=new Stack<>();
        int[] result=new int[num.length];
        int index=0;
        for(int cur:num){
            while(!stack.isEmpty()&&stack.peek()>=cur)
                stack.pop();
            if(stack.isEmpty())
                result[index++]=cur;
            else
                result[index++]=stack.peek();
            stack.push(cur);
        }
        return result;
        // Write your code here
    }
}
