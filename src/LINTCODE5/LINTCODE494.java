package LINTCODE5;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE494 {
    /*Description
    * 利用两个队列来实现一个栈的功能
    * */

    /*Solution
    * 注意两个队列之间数据的转移
    * */

    Queue<Integer> queue1=new LinkedList<>();
    Queue<Integer> queue2=new LinkedList<>();

    public void push(int x) {
        queue1.add(x);
        // write your code here
    }

    /*
     * @return: nothing
     */
    public void pop() {
        while(queue1.size()>1){
            queue2.add(queue1.poll());
        }
        queue1.poll();
        while(!queue2.isEmpty())
            queue1.add(queue2.poll());
            // write your code here
    }

    /*
     * @return: An integer
     */
    public int top() {
        while(queue1.size()>1){
            queue2.add(queue1.poll());
        }
        int result=queue1.peek();
        queue2.add(queue1.poll());
        while(!queue2.isEmpty())
            queue1.add(queue2.poll());
        return result;
        // write your code here
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        return queue1.isEmpty();
        // write your code here
    }
}
