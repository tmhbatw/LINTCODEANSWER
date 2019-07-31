package LINTCODE7;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE642 {
    /*Description
    * 给出一串整数流和窗口大小，计算滑动窗口中所有整数的平均值。
    * */

    class MovingAverage {
        /*
         * @param size: An integer
         */
        Queue<Integer> num;
        double curSum=0.0;
        double size;
        public MovingAverage(int size) {
            this.num=new LinkedList<>();
            this.size=size;
            // do intialization if necessary
        }

        /*
         * @param val: An integer
         * @return:
         */
        public double next(int val) {
            if(num.size()==size) {
                curSum -= num.poll();
            }
            num.add(val);
            curSum+=val;
            return curSum/num.size();
            // write your code here
        }
    }
}
