package LINTCODE2;

import datastructure.ListNode;

public class LINTCODE102 {
    /*Description
    * Given a linked list, determine if it has a cycle in it.
    * */

    /*Solution
    * 创建一个快链表以及一个慢链表，快链表一次走两个节点，慢链表一次走一个节点
    * 如果快节点与慢节点相遇，那么链表一定循环
    * */

    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(true){
            if(fast==null||fast.next==null)
                return false;
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
                return true;

        }
        // write your code here
    }

}
