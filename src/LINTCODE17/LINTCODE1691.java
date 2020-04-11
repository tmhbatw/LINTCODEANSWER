package LINTCODE17;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LINTCODE1691 {
    /*Description
    *给出一个股票n天的价格，每天最多只能进行一次交易，可以选择买入一支股票或卖出一支股票或放弃交易，输出能够达到的最大利润值
    * */

    public int getAns(int[] a) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        int result=0;
        for(int temp:a){
            if(!queue.isEmpty()&&queue.peek()<temp){
                result+=temp-queue.poll();
                queue.add(temp);
            }
            queue.add(temp);
        }
        return result;
        // write your code here
    }
}
