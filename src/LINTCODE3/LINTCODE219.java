package LINTCODE3;

import datastructure.ListNode;

public class LINTCODE219 {

    /*Description
    * 在链表中插入一个节点。
    * */

    /*Solution
    *遍历链表，注意保留前一节点
    * */
    public ListNode insertNode(ListNode head, int val) {
        if(head==null||head.val>val){
            ListNode hea=new ListNode(val);
            hea.next=head;
            return hea;
        }
        ListNode pre=head;
        ListNode curr=head.next;
        while(curr!=null&&curr.val<val){
            curr=curr.next;
            pre=pre.next;
        }
        pre.next=new ListNode(val);
        pre.next.next=curr;
        return head;
        // write your code here
    }
}
