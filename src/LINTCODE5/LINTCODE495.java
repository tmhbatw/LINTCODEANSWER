package LINTCODE5;

public class LINTCODE495 {
    /*Description
    * Implement a stack. You can use any data structure inside a stack except stack itself to implement it.
    * */

    /*Solution
    * 实现一个栈，那么可以使用一个数组以及指向数组当前存储位置的下标即可
    * */

    int[] num=new int[1000];
    int index=0;

    public void push(int x) {
        num[index++]=x;
        // write your code here
    }

    /*
     * @return: nothing
     */
    public void pop() {
        index--;
        // write your code here
    }

    /*
     * @return: An integer
     */
    public int top() {
        return num[index];
        // write your code here
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        return index==0;
        // write your code here
    }
}
