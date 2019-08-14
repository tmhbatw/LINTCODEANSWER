package LINTCODE9;

import datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE822 {
    /*Description
    * 给出一个链表，并将链表的值以倒序存储到数组中。
    * */

    public List<Integer> reverseStore(ListNode head) {
        List<Integer> result=new ArrayList<>();
        while(head!=null){
            result.add(0,head.val);
            head=head.next;
        }
        return result;
        // write your code here
    }
}
