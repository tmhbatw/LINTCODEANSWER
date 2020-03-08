package LINTCODE6;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE546 {
    interface InterfaceQueue {
        void push(int element);

        // define an interface for pop method
        /* write your code here */
        int pop();

        // define an interface for top method
        /* write your code here */
        int top();
    }

    class MyQueue implements InterfaceQueue {
        Queue<Integer> queue;
        /* you can declare your private attributes here */
        public MyQueue() {
            queue=new LinkedList<>();
            // do initialization if necessary
        }

        // implement the push method
        /* write your code here */
        @Override
        public void push(int val) {
            queue.add(val);

        }

        // implement the pop method
        /* write your code here */
        @Override
        public int pop() {
            return queue.poll();
        }

        // implement the top method
        /* write your code here */
        @Override
        public int top() {
            return queue.peek();
        }
    }
}
