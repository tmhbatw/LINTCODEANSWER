package LINTCODE17;

import datastructure.ListNode;

public class LINTCODE1609 {
    /*Description
    *给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
    * 如果有两个中间结点，则返回第二个中间结点。
    * */

    /*Solution
    * 快慢节点法
    * */

    public ListNode middleNode(ListNode head) {
        ListNode fast=head,slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
        // write your code here.
    }
}
