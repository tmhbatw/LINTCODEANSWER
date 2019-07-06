package LINTCODE3;

import datastructure.ListNode;

public class LINTCODE228 {
    /*Description
    * 找链表的中点。
    * */

    /*Solution
    *快慢指针
    * */

    public ListNode middleNode(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
        // write your code here
    }
}
