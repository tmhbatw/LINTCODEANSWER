package LINTCODE5;

import datastructure.ListNode;

public class LINTCODE451 {
    /*Description
    * Given a linked list, swap every two adjacent nodes and return its head.
    * */

    /*Solution
    *可以创建一个新的头节点以便于返回
    * */

    public ListNode swapPairs(ListNode head) {
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode cur=result;
        while(head!=null&&head.next!=null){
            ListNode next=head.next.next;

            cur.next=head.next;
            head.next.next=head;
            head.next=next;
            cur=cur.next.next;
            head=head.next;
        }
        return result.next;
        // write your code here
    }
}
