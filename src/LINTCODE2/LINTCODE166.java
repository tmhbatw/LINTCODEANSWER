package LINTCODE2;

import datastructure.ListNode;

public class LINTCODE166 {
    /*Description
    * Find the nth to last element of a singly linked list.
    * The minimum number of nodes in list is n.
    * */

    /*Solution
    * 从头找到第k个节点，k节点继续往后遍历的同时令另一个节点从头开始出发
    * 当k节点到达队尾时，后出发节点的位置就是距离最后节点k的位置
    * */

    public ListNode nthToLast(ListNode head, int n) {
        ListNode before=head;
        ListNode after=head;
        while(n-->0){
            before=before.next;
        }
        while(before!=null){
            before=before.next;
            after=after.next;
        }
        return after.next;
        // write your code here
    }

}
