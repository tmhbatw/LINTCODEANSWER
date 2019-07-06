package LINTCODE5;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE492 {
    /*Description
    * 实现一个队列的操作
    * enqueue(item).将新元素放入队列中。
    * dequeue(). 将第一个元素移出队列，返回它。
    * */

    /*Solution
    * ArrayList实现
    * */

    private List<Integer> temp=new ArrayList<>();

    public void enqueue(int item) {
        temp.add(item);
        // write your code here
    }

    /*
     * @return: An integer
     */
    public int dequeue() {
        int result=temp.get(0);
        temp.remove(0);
        return result;
        // write your code here
    }
}
