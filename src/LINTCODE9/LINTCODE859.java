package LINTCODE9;

import java.util.PriorityQueue;
import java.util.Stack;

public class LINTCODE859 {
    /*Description
    * 设计一个支持push，pop，top，peekMax和popMax操作的最大栈。
    * push(x) -- 将元素x添加到栈中。
    * pop() -- 删除栈中最顶端的元素并将其返回。
    * top() -- 返回栈中最顶端的元素。
    * peekMax() -- 返回栈中最大的元素。
    * popMax() -- 返回栈中最大的元素，并将其删除。如果有多于一个最大的元素，只删除最靠近顶端的一个元素。
    * */

    class MaxStack {
        Stack<Integer> normal;
        Stack<Integer> max;
        public MaxStack() {
            normal=new Stack<>();
            max=new Stack<>();
            // do intialization if necessary
        }

        public void push(int x) {
            normal.push(x);
            if(max.empty()||max.peek()<=x)
                max.push(x);
            // write your code here
        }

        public int pop() {
            int cur=normal.pop();
            if(cur==max.peek())
                max.pop();
            return cur;
            // write your code here
        }

        public int top() {
            return normal.peek();
            // write your code here
        }

        public int peekMax() {
            return max.peek();
            // write your code here
        }

        public int popMax() {
            int cur=max.pop();
            Stack<Integer> curStack=new Stack<>();
            while(normal.peek()!=cur)
                curStack.push(normal.pop());
            normal.pop();
            while(!curStack.empty()){
                int curNumber=curStack.pop();
                if(max.peek()<=curNumber)
                    max.push(curNumber);
                normal.push(curNumber);
            }
            return cur;
            // write your code here
        }
    }
}
