package LINTCODE6;

import datastructure.ListNode;

public class LINTCODE511 {

    /*Description
    * 给你一个链表以及两个权值v1和v2，交换链表中权值为v1和v2的这两个节点。
    * 保证链表中节点权值各不相同，如果没有找到对应节点，那么什么也不用做。
    * */


    public ListNode swapNodes(ListNode head, int v1, int v2) {
        ListNode vv1 = null,vv2=null;
        ListNode curr=head;
        while(curr!=null){
            if(curr.val==v1){
                vv1=curr;
            }else if(curr.val==v2){
                vv2=curr;
            }
            curr=curr.next;
        }
        if(vv1!=null&&vv2!=null){
            vv1.val=v2;
            vv2.val=v1;
        }
        return head;
        // write your code here
    }
}
