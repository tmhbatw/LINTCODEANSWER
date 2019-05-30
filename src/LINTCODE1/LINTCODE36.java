package LINTCODE1;

import datastructure.ListNode;

public class LINTCODE36 {
    /*Description
    * 翻转链表中第m个节点到第n个节点的部分
    * */


    /*Solution
    * 与35题思路基本相似，不同点在于找到第m个节点以及第n个节点
    * */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //特殊情况处理
        if(head==null||m==n)
            return head;
        ListNode result=new ListNode(0);//增加一个头节点便于处理
        result.next=head;
        ListNode start=result;//用来保存m之前不变的节点
        for(int i=0;i<m-1;i++){
            start=start.next;
        }
        ListNode pre=null, curr=start.next,next=curr.next;
        ListNode end=curr;//用来转换节点的最后一个节点
        for(int i=0;i<n-m;i++){
            curr.next=pre;
            pre=curr;
            curr=next;
            next=next.next;
        }
        curr.next=pre;
        pre=curr;
        curr=next;
        start.next=pre;
        end.next=curr;
        return result.next;
        // write your code here
    }
}
