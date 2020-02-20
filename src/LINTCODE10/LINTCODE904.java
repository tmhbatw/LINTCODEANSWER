package LINTCODE10;

import datastructure.ListNode;

public class LINTCODE904 {
   /*Description
   * 给定一个非负整数，这个整数表示为一个非空的单链表，每个节点表示这个整数的一位。返回这个整数加一。
   * 除了0本身，所有数字在最高位前都没有0。
   * 列表的头节点存的是这个整数的最高位。
   * */

    public ListNode plusOne(ListNode head) {
        StringBuilder sb=new StringBuilder();
        while(head!=null){
            sb.append(head.val);
            head=head.next;
        }
        int index=sb.length()-1;
        while(index!=-1&&sb.charAt(index)=='9'){
            index--;
        }
        if(index==-1){
            ListNode result=new ListNode(1);
            ListNode cur=result;
            for(int i=0;i<sb.length();i++){
                cur.next=new ListNode(0);
                cur=cur.next;
            }
            return result;
        }
        ListNode result=new ListNode(0);
        ListNode cur=result;
        for(int i=0;i<index;i++){
            cur.next=new ListNode(sb.charAt(i)-'0');
            cur=cur.next;
        }
        cur.next=new ListNode(sb.charAt(index)-'0'+1);
        cur=cur.next;
        for(int i=0;i<sb.length()-index-1;i++){
            cur.next=new ListNode(0);
            cur=cur.next;
        }
        return result.next;
        // Write your code here
    }
}
