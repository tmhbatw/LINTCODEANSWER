package LINTCODE2;

import datastructure.ListNode;

public class LINTCODE113 {
    /*Description
    * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
     * */

    /*Solution
    * 112题的变式题，如果当前节点与下一节点相等则保留这个值并将所有这个值的节点去掉
    * */


    public ListNode deleteDuplicates(ListNode head) {
        ListNode result=new ListNode(Integer.MIN_VALUE);
        result.next=head;
        ListNode curr=result.next;
        ListNode pre=result;
        ListNode next;
        int val=Integer.MIN_VALUE;
        while(curr!=null){
            next=curr.next;
            if(val!=Integer.MIN_VALUE){
                if(curr.val==val){
                    curr=curr.next;
                }else if(next==null||next.val!=curr.val){
                    pre.next=curr;
                    pre=pre.next;
                    curr=curr.next;
                    val=Integer.MIN_VALUE;
                }else{
                    val=curr.val;
                    curr=curr.next;
                    val=curr.val;
                }
            }else{
                if(next==null||curr.val!=next.val){
                    pre.next=curr;
                    pre=pre.next;
                    curr=curr.next;
                }else{
                    val=curr.val;
                    curr=curr.next;
                }
            }
        }
        pre.next=null;
        return result.next;
        // write your code here
    }
}
