package LINTCODE2;

import datastructure.ListNode;

public class LINTCODE174 {
    /*Description
    * Given a linked list, remove the nth node from the end of list and return its head.
    * */

    /*Solution
    * 找到距离末尾第k+1个节点，使其next等于next.next即可
    * 创建一个新的节点位于头节点之前以防止头节点自身被删除
    * */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode curr=result;
        ListNode cur=result;
        while(n-->0){
            curr=curr.next;
        }
        while(curr.next!=null){
            curr=curr.next;
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return result.next;
        // write your code here
    }

}
