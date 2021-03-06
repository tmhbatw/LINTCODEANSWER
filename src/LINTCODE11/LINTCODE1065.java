package LINTCODE11;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1065 {
    /*Description
    * 实现MyCalendar类来存储您的活动。 如果新添加的活动没有重复，则可以添加。
    * 你的类将有方法book(int start，int end)。 这代表左闭右开的间隔[start，end)有了预定，范围内的实数x，都满足start <= x < end。
    * 当两个事件有一些非空交集时（即，两个事件在共同的时间都有预定），就会发生重复预订。
    * 每次调用MyCalendar.book方法时，如果没有发生重复预定，那么事件可以成功添加到日历，且返回true。 否则，返回false，并且事件不会添加到日历中。
    * 你的类以此方式被调用：MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end);
    * */

    class MyCalendar {
        List<int[]> list;

        public MyCalendar() {
            list=new ArrayList<>();
        }

        public boolean book(int start, int end) {
            if(list.size()==0){
                list.add(new int[]{start,end});
                return true;
            }
            for(int i=0;i<list.size();i++){
                if(end<=list.get(i)[0]){
                    if(i==0||list.get(i-1)[1]<=start){
                        list.add(i,new int[]{start,end});
                        return true;
                    }else
                        return false;
                }
            }
            if(list.get(list.size()-1)[1]<=start){
                list.add(new int[]{start,end});
                return true;
            }else
                return false;

        }
    }
}
