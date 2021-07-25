package LINTCODE11;

import java.util.Map;
import java.util.TreeMap;

public class LINTCODE1063 {
    /*Description
    * 实现一个MyCalendarThree 来储存你的时间。一个新的事件 总是 可以被加入。
    * 你的类会有一种方法：book(int start, int end)。 正式的说，这代表在一个半开区间 [start, end) 上进行预订，
    * 实数x 的范围即 start <= x < end。
    * 当K个事件有一个非空交集的时候，一个K预订将会发生。（即，某一个时刻对于K个事件是共用的）
    * 对于每一个对于方法 MyCalendar.book的调用，返回一个整数K，代表日历中存在K预订的最大的整数。
    * 你的类将会这样被调用: MyCalendarThree cal = new MyCalendarThree(); MyCalendarThree.book(start, end)。
    * */

    class MyCalendarThree {
        TreeMap<Integer,Integer> map;

        public MyCalendarThree() {
            this.map=new TreeMap<>();
        }

        public int book(int start, int end) {
            int startNumber = map.getOrDefault(start, 0);
            map.put(start,startNumber+1);
            int endNumber = map.getOrDefault(end,0);
            map.put(end,endNumber-1);
            int count =0;
            int res= 0;
            for(int cur: map.values()){
                count+=cur;
                res= Math.max(res, count);
            }
            return res;
        }
    }
}
