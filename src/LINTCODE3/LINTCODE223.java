package LINTCODE3;

import datastructure.ListNode;

public class LINTCODE223 {
    /*Description
    * 设计一种方式检查一个链表是否为回文链表。
    * */

    /*Solution
    *可以先寻找中间节点，将中间节点之后的节点翻转，然后判断两个链表的值是否完全相同进行判断
    * */

    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;
        ListNode fast=head,slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode pre=null;
        ListNode next=slow;
        while(slow.next!=null){
            next=slow.next;
            slow.next=pre;
            pre=slow;
            slow=next;
        }
        slow.next=pre;
        while(head!=null&&slow!=null){
            if(head.val!=slow.val)
                return false;
            head=head.next;
            slow=slow.next;
        }
        return true;
        // write your code here
    }
}
