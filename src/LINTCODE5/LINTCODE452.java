package LINTCODE5;

import datastructure.ListNode;

public class LINTCODE452 {
    /*Description
    *删除链表中等于给定值 val 的所有节点。
    * */

    /*Solution
    *
    * */

    public ListNode removeElements(ListNode head, int val) {

        ListNode result=new ListNode(0);
        result.next=head;
        ListNode cur=result;
        while(cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return result.next;


        // write your code here
    }

}
