package LINTCODE1;

import datastructure.ListNode;

public class LINTCODE35 {
    /*Description
    * Reverse a linked list.
    * */

    /*Solution
    * 创建pre、curr、next三个节点分别保存之前的节点（转移之后则为当前节点之后的节点）、当前节点、当前节点下一节点
    * 令curr节点下一节点为pre，pre指向该curr节点，curr指向next节点，next节点指向next的下一节点，则完成了当前节点的翻转
    * 遍历head节点进行全部翻转
    * */
    public ListNode reverse(ListNode head) {
        //head为null时的特殊处理
        if(head==null)
            return null;
        ListNode pre=null, curr=head,next=curr.next;
        while(next!=null){
            curr.next=pre;
            pre=curr;
            curr=next;
            next=next.next;
        }
        curr.next=pre;
        return curr;
        // write your code here
    }
}
