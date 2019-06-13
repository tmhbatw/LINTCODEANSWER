package LINTCODE5;

import datastructure.ListNode;

public class LINTCODE450 {
    /*Description
    *给你一个链表以及一个k,将这个链表从头指针开始每k个翻转一下。
    * 链表元素个数不是k的倍数，最后剩余的不用翻转。
    * */

    /*Solution
    *每k个链表进行一次翻转即可
    * */

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode cur=result.next;
        ListNode last=result;
        while(judge(cur,k)){
            ListNode las=cur;
            ListNode curr=cur;
            ListNode pre=null;
            ListNode next;
            for(int i=0;i<k;i++){
                next=curr.next;
                curr.next=pre;
                pre=curr;
                curr=next;
            }
            last.next=pre;
            last=las;
            cur=curr;
        }
        last.next=cur;
        return result.next;


        // write your code here
    }

    private boolean judge(ListNode node, int k){
        ListNode cur=node;
        while(k-->0){
            if(cur==null)
                return false;
            cur=cur.next;

        }
        return true;
    }



}
