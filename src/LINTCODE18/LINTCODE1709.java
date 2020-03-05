package LINTCODE18;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1709 {
    /*Description
    * 写一个 RecentCounter 类来计算最近的请求。
    * 它只有一个方法：ping(int t)，其中 t 代表以毫秒为单位的某个时间。
    * 返回从 3000 毫秒前到现在的 ping 数。
    * 任何处于 [t - 3000, t] 时间范围之内的 ping 都将会被计算在内，包括当前（指 t 时刻）的 ping。
    * 保证每次对 ping 的调用都使用比之前更大的 t 值
    * */

    class RecentCounter {
        Queue<Integer> queue;

        public RecentCounter() {
            queue=new LinkedList<>();
        }

        public int ping(int t) {
            queue.add(t);
            int start=t-3000;
            while(queue.peek()<start)
                queue.poll();
            return queue.size();
        }
    }
}
