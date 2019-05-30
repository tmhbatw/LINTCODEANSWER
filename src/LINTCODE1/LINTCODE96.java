package LINTCODE1;

import datastructure.ListNode;

public class LINTCODE96 {
    /*Description
    * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
    * You should preserve the original relative order of the nodes in each of the two partitions.
    * */

    /*Solution
    * 两次遍历该链表即可
    * */

    public ListNode partition(ListNode head, int x) {
        if(head==null)
            return head;
        ListNode start=new ListNode(0);
        ListNode end=new ListNode(0);
        ListNode startcur=start;
        ListNode endcur=end;
        ListNode cur=head;
        while(cur!=null){
            if(cur.val<x) {
                startcur.next = cur;
                startcur=startcur.next;
            }else{
                endcur.next=cur;
                endcur=endcur.next;
            }
            cur=cur.next;
        }
        endcur.next=null;
        startcur.next=end.next;
        return start.next;
        // write your code here
    }

}
