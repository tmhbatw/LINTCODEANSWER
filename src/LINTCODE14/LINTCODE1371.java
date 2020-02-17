package LINTCODE14;

import datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LINTCODE1371 {
    /*Description
    * 给定一个链表（链表结点包含一个整型值）的头结点 head。
    * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
    * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
    * */

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set=new HashSet<>();
        for(int cur:G)
            set.add(cur);
        int number=set.size();
        int result=0;
        while(head!=null&&number>0){
            int val=head.val;
            if(set.contains(val)){
                result++;
                number--;
                head=head.next;
                while(head!=null&&set.contains(head.val)){
                    head=head.next;
                    number--;
                }
            }
            else{
                head=head.next;
            }
        }
        return result;
        // Write your code here
    }
}
