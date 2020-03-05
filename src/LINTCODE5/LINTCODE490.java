package LINTCODE5;

import java.util.Stack;

public class LINTCODE490 {
    /*Description
    * 假如你有一堆的盘子。如果你堆得太高的话，就可能会垮掉。所以，在真实的生活中，如果盘子叠到一定高度，你会重新开始堆新的一堆盘子。
    * 实现这样的一个数据结构，我们称之为栈集，来模拟这个过程。这个栈集包含若干个栈（可以理解为若干堆的盘子），
    * 如果一个栈满了，就需要新建一个栈来装新加入的项。你需要实现栈集的两个方法，push(item) 和 pop()，让这个栈集对外表现得就像是一个栈在进行操作一样。
    * */

    class SetOfStacks {
        /*
         * @param capacity: An inetger, capacity of sub stack
         */
        Stack<Stack<Integer>> stack;
        int cap;
        public SetOfStacks(int capacity) {
            stack=new Stack<>();
            cap=capacity;
            // do intialization if necessary
        }

        /*
         * @param v: An integer
         * @return: nothing
         */
        public void push(int v) {
            if(stack.isEmpty()||stack.peek().size()==cap){
                Stack<Integer> curStack=new Stack<>();
                curStack.push(v);
                stack.push(curStack);
            }else{
                stack.peek().add(v);
            }
            // write your code here
        }

        /*
         * @return: An integer
         */
        public int pop() {
            if(stack.peek().size()==1){
                Stack<Integer> cur=stack.pop();
                return cur.pop();
            }
            return stack.peek().pop();

            // write your code here
        }
    }
}
