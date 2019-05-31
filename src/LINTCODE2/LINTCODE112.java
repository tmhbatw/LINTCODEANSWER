package LINTCODE2;

import datastructure.ListNode;

public class LINTCODE112 {
    /*Description
    * Given a sorted linked list, delete all duplicates such that each element appear only once.
    * */

    /*Solution
    * 用一个变量保存上一个节点数值
    * 当变量与当前节点相等时去掉当前节点
    * */

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        int val=head.val;
        ListNode curr=head.next;
        ListNode pre=head;
        ListNode next=head;
        while(curr!=null){
            if(curr.val==val){
                curr=curr.next;
                pre.next=curr;
                pre=pre.next;
            }else{
                val=curr.val;
                curr=curr.next;
                pre=pre.next;
            }
        }
        return next;
        // write your code here
    }
}
