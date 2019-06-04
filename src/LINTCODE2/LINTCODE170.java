package LINTCODE2;

import datastructure.ListNode;

public class LINTCODE170 {
    /*Description
    * Given a list, rotate the list to the right by k places, where k is non-negative
    * */

    /*Solution
    * 首先k的值很有可能比链表的长度大，因此要计算出链表的长度然后取余
    * 然后找到距离最后节点k个位置的结果节点头部，与原先节点的前面部分进行拼接即可
    * */

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        k=k%getLength(head);
        if(k==0)
            return head;
        ListNode pre=head;
        ListNode next=head;
        while(k-->0){
            pre=pre.next;
        }
        while(pre.next!=null){
            pre=pre.next;
            next=next.next;
        }
        pre.next=head;
        ListNode result=next.next;
        next.next=null;
        return result;

        // write your code here
    }

    //因为k的数值很有可能大于链表的长度，因此要获取链表长度然后取余
    private int getLength(ListNode root){
        ListNode curr=root;
        int result=0;
        while(curr!=null){
            result++;
            curr=curr.next;
        }
        return result;
    }
}
