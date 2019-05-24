package LINTCODE;

import java.util.Stack;

public class LINTCODE40 {
    /*Description
    * 正如标题所述，你需要使用两个栈来实现队列的一些操作。
    * 队列应支持push(element)，pop() 和 top()，其中pop是弹出队列中的第一个(最前面的)元素。
    * pop和top方法都应该返回第一个元素的值。
    * */

    /*Solution
    * 可以创建一个数组来实现
    * 使用栈思路则可以创建一个栈用来存放进入的元素，当输出时将他输出到另一个栈中，另一个栈逐个跳出则为所求
    * */
    //栈解决思路
    Stack<Integer> a=new Stack<>();
    Stack<Integer> b=new Stack<>();
    public void push(int element) {
        a.push(element);
        // write your code here
    }

    /*
     * @return: An integer
     */
    public int pop() {
        if(b.empty()){
            while(!a.empty())
                b.push(a.pop());
        }
        return b.pop();
        // write your code here
    }

    /*
     * @return: An integer
     */
    public int top() {
        if(b.empty()){
            while(!a.empty())
                b.push(a.pop());
        }
        return b.peek();
        // write your code here
    }


    //数组解决思路1
/*    int[] num=new int[1000];
    int i=0;
    int j=0;
    public void push(int element) {
        num[i++]=element;
        // write your code here
    }

    *//*
     * @return: An integer
     *//*
    public int pop() {
        return num[j++];
        // write your code here
    }

    *//*
     * @return: An integer
     *//*
    public int top() {
        return num[j];
        // write your code here
    }*/
}
