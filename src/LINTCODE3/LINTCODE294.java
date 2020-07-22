package LINTCODE3;

import datastructure.ListNode;

import java.util.Stack;

public class LINTCODE294 {
    /*Description
    * 给出一个字符链表，对其进行简化。
    * 简化的过程为，保留链表的头尾节点，用数字代替掉中间的部分。
    * 数字也要用字符链表表示。
    * */

    public ListNode simplify(ListNode head) {
        if(head==null||head.next==null||head.next.next==null)
            return head;
        ListNode result=head;
        int res=0;
        while(head.next!=null){
            head=head.next;
            res++;
        }
        res--;
        Stack<Integer> stack=new Stack<>();
        while(res!=0){
            stack.push(res%10);
            res/=10;
        }
        ListNode cur=result;
        while(!stack.isEmpty()) {
            cur.next = new ListNode(stack.pop()+48);
            cur = cur.next;
        }
        cur.next=head;
        return result;
        // write your code here
    }
}
