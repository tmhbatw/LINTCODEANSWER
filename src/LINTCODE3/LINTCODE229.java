package LINTCODE3;

import java.util.Stack;

public class LINTCODE229 {
    /*Description
    * 请设计一种方法将一个栈进行升序排列 （最大的数在最上面）。
    * 你可以使用另外一个栈来辅助操作，但不可将这些数复制到另外一个数据结构中 （如，数组）。
    * */

    /*Solution
    * 遍历排序，创建一个新的栈保留当前遍历的排序结果
    * */

    public void stackSorting(Stack<Integer> stk) {
        Stack<Integer> temp=new Stack<>();
        while(!stk.empty()){
            int cur=stk.pop();
            int count=0;
            while(!temp.empty()&&temp.peek()<cur){
                stk.push(temp.pop());
                count++;
            }
            temp.push(cur);
            while(count-->0){
                temp.push(stk.pop());
            }
        }
        while(!temp.empty())
            stk.push(temp.pop());
        // write your code here
    }
}
