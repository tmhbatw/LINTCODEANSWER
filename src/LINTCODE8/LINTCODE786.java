package LINTCODE8;

import datastructure.ListNode;

public class LINTCODE786 {
    /*Description
    *给定一个链表，求出这个链表的带权和。链表结点的权值指的是该结点到链表尾节点的结点数。
    * */

    public int weightedSumReverse(ListNode head) {
        int length=0;
        ListNode cur=head;
        while(cur!=null){
            length++;
            cur=cur.next;
        }
        int result=0;
        while(head!=null){
            result+=head.val*length;
            head=head.next;
            length--;
        }
        return result;
        // ListNode -> val: the value of node ,ListNode -> next: the next node of this node
    }
}
