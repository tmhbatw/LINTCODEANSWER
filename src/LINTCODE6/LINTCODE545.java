package LINTCODE6;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LINTCODE545 {

    /*Description
    * 实现一个数据结构，提供下面两个接口
    * 1.add(number) 添加一个元素
    * 2.topk() 返回前K大的数
    * */

    /*Solution
    * 与上一题思路基本相同
    * */

    int size;
    PriorityQueue<Integer> queue;

    public LINTCODE545(int k) {
        queue=new PriorityQueue<>();
        size=k;
        // do intialization if necessary
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        queue.add(num);
        if(queue.size()==size+1)
            queue.poll();
        // write your code here
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        List<Integer> result=new ArrayList<>();
        while(!queue.isEmpty()) {
            result.add(0, queue.poll());
        }
        for(int num:result){
            queue.add(num);
        }
        return result;
        // write your code here
    }
}
