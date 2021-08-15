package LINTCODE13;

import datastructure.Interval;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1280 {
    /*Description
    * 给定一个非负整数的数据流输入 a1，a2，…，an，…，将到目前为止看到的数字总结为不相交的区间列表。
    * 例如，假设数据流中的整数为 1，3，7，2，6，…，每次的总结为：
    * */

    public class Solution {
        /**
         * @param val: An integer.
         * @return: nothing
         */

        List<Interval> list=new ArrayList<>();
        public void addNum(int val) {
            for(int i=0;i<list.size();i++){
                if(list.get(i).start<=val && list.get(i).end>=val)
                    return;
                if(list.get(i).start>val){
                    if(list.get(i).start-val==1) {
                        list.get(i).start -= 1;
                        if(i>=1&&list.get(i-1).end==val-1){
                            list.get(i-1).end=list.get(i).end;
                            Interval remove = list.remove(i);
                        }
                    }else{
                        if(i>=1&&list.get(i-1).end==val-1){
                            list.get(i-1).end +=1;
                        }else{
                            list.add(new Interval(val,val));
                        }
                    }
                }
            }
            list.add(new Interval(val,val));
            // write your code here
        }

        /**
         * @return: A list of intervals.
         */
        public List<Interval> getIntervals() {
            return list;
            // write your code here
        }
    }
}
