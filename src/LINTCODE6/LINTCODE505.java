package LINTCODE6;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE505 {
    /*Description
    * 实现下面两个方法：
    * 1.hit(timestamp) 建立一个时间戳
    * 2.get_hit_count_in_last_5_minutes(timestamp) 得到最后5分钟时间戳个
    * */

    class WebLogger {

        private Queue<Integer> queue;

        public WebLogger() {
            queue=new LinkedList<>();
            // do intialization if necessary
        }

        /*
         * @param timestamp: An integer
         * @return: nothing
         */
        public void hit(int timestamp) {
            queue.add(timestamp);
            // write your code here
        }

        /*
         * @param timestamp: An integer
         * @return: An integer
         */
        public int get_hit_count_in_last_5_minutes(int timestamp) {
            timestamp-=300;
            while(!queue.isEmpty()&&queue.peek()<=timestamp)
                queue.poll();
            return queue.size();
             // write your code here
        }
    }
}
