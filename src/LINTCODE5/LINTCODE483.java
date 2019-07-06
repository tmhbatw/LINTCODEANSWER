package LINTCODE5;

import datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE483 {

    /*Description
    * 将一个链表转换为一个数组。
    * */

    /*Solution
    * 遍历
    * */

    public List<Integer> toArrayList(ListNode head) {
        List<Integer> result=new ArrayList<>();
        while(head!=null){
            result.add(head.val);
            head=head.next;
        }
        return result;
        // write your code here
    }
}
