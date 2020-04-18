package LINTCODE11;

import java.util.Map;
import java.util.TreeMap;

public class LINTCODE1064 {
    /*Description
    *实现MyCalendarTwo类来存储您的事件。 如果添加活动不会导致三重预订，则可以添加新活动。
    * 你的类将有一个方法，book(int start, int end)。 这代表左闭右开的间隔[start, end)有一个预订，范围内的实数x，都满足start <= x < end。
    * 当三个事件具有一些非空交集时（即，有一个时间同时有三个预定），会发生三重预订。
    * 每次调用MyCalendar.book时，如果没有三重预定，则事件可以成功添加到日历，且返回true。 否则，返回false，并且事件不会添加到日历中。
    * 你的类以此方式被调用：MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end);
    * */

    class MyCalendarTwo {
        TreeMap<Integer,Integer> map;

        public MyCalendarTwo() {
            map=new TreeMap<>();
        }

        public boolean book(int start, int end) {
            map.put(start,map.getOrDefault(start,0)+1);
            map.put(end,map.getOrDefault(end,0)-1);
            int count=0;
            for(Map.Entry entry:map.entrySet()){
                count+=(int)entry.getValue();
                if(count>=3){
                    map.put(start,map.get(start)-1);
                    map.put(end,map.get(end)+1);
                    return false;
                }
            }
            return true;
        }
    }

}
