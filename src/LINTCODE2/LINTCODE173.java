package LINTCODE2;

import datastructure.ListNode;

public class LINTCODE173 {
    /*Description
    * Sort a linked list using insertion sort.
    * */

    /*Solution
    * 简单的插入排序，注意保存节点不要造成数据丢失即可
    * */

    public ListNode insertionSortList(ListNode head) {
        ListNode result=new ListNode(-1);
        while(head!=null){
            ListNode cur=head;
            head=head.next;
            ListNode curr=result;
            while(curr.next!=null&&curr.next.val<=cur.val){
                curr=curr.next;
            }
            ListNode next=curr.next;
            curr.next=cur;
            cur.next=next;
        }
        return result.next;
        // write your code here
    }


}
