package LINTCODE2;

import datastructure.ListNode;

public class LINTCODE165 {
    /*Description
    * 将两个排序链表合并为一个新的排序链表
    * */

    /*Solution
    * 遍历两个链表，将较小的节点优先输出
    * */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode curr=result;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                curr.next=l1;
                l1=l1.next;
            }else{
                curr.next=l2;
                l2=l2.next;
            }
            curr=curr.next;
        }
        if(l1==null){
            curr.next=l2;
        }else
            curr.next=l1;
        return result.next;
        // write your code here
    }
}
