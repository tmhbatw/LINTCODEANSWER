package LINTCODE1;

import datastructure.ListNode;

public class LINTCODE99 {
    /*Description
    * Given a singly linked list L: L0 → L1 → … → Ln-1 → Ln
    * reorder it to: L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
    * */

    /*Solution
    * 使用慢链表将链表拆开，将后一部分翻转并插入前面的链表中
    * */

    public void reorderList(ListNode head) {
        if(head==null||head.next==null)
            return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode curr=slow;
        slow=slow.next;
        curr.next=null;
        ListNode pre=null;
        ListNode cur=null;
        ListNode next=slow;
        while(next!=null){
            cur=next;
            next=next.next;
            cur.next=pre;
            pre=cur;
        }
        while(cur!=null){
            ListNode n=head.next;
            head.next=cur;
            head=head.next;
            head.next=n;
            head=head.next;
            cur=cur.next;

        }

        // write your code here
    }
    private void output(ListNode node){
        while(node!=null){
            System.out.print(node.val+">");
            node=node.next;
        }
    }

}
