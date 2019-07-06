package LINTCODE3;

import datastructure.ListNode;

public class LINTCODE225 {

    /*Description
    * 在链表中找值为 value 的节点，如果没有的话，返回空(null)。
    * */

    /*Solution
    * 遍历链表即可
    * */

    public ListNode findNode(ListNode head, int val) {
        while(head!=null&&head.val!=val)
            head=head.next;
        return head;
        // write your code here
    }
}
