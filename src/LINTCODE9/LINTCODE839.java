package LINTCODE9;

import datastructure.Interval;

import java.util.*;

public class LINTCODE839 {
    /*Description
    * 合并两个已排序的区间列表，并将其作为一个新的有序区间列表返回。
    * 新的区间列表应该通过拼接两个列表的区间并按升序排序。
    * */

    /*Solution
    * 使用两个同向指针，每次取出start值较小的interval进行操作
    * 与堆中interval进行比较，如果没有重合则直接压入，若有重合则merge后压入
    * */

    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        Stack<Interval> stack=new Stack<>();
        int index1=0,index2=0;
        while(index1<list1.size()||index2< list2.size()){
            Interval cur;
            if(index1==list1.size())
                cur=list2.get(index2++);
            else if(index2==list2.size())
                cur=list1.get(index1++);
            else{
                if(list1.get(index1).start<list2.get(index2).start)
                    cur=list1.get(index1++);
                else
                    cur=list2.get(index2++);
            }
            if(stack.empty()||stack.peek().end<cur.start)
                stack.push(cur);
            Interval merge=stack.pop();
            stack.push(new Interval(merge.start,Math.max(cur.end,merge.end)));
        }
        return new ArrayList<>(stack);
        // write your code here
    }

}
