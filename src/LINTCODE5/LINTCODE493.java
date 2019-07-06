package LINTCODE5;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE493 {
    /*Description
    *Implement a Queue by linked list. Provide the following basic methods:
    * push_front(item). Add a new item to the front of queue.
    * push_back(item). Add a new item to the back of the queue.
    * pop_front(). Move the first item out of the queue, return it.
    * pop_back(). Move the last item out of the queue, return it.
    * */

    /*Solution
    * 使用ArrayList实现
    * */

    /*
     * @param item: An integer
     * @return: nothing
     */

    private List<Integer> temp=new ArrayList<>();
    public void push_front(int item) {
        temp.add(0,item);
        // write your code here
    }

    /*
     * @param item: An integer
     * @return: nothing
     */
    public void push_back(int item) {
        temp.add(item);
        // write your code here
    }

    /*
     * @return: An integer
     */
    public int pop_front() {
        int result=temp.get(0);
        temp.remove(0);
        return result;
        // write your code here
    }

    /*
     * @return: An integer
     */
    public int pop_back() {
        int result=temp.get(temp.size()-1);
        temp.remove(temp.size()-1);
        return result;
        // write your code here
    }
}
