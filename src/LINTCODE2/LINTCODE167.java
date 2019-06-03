package LINTCODE2;

import datastructure.ListNode;

public class LINTCODE167 {
    /*Description
    * 你有两个用链表代表的整数，其中每个节点包含一个数字。数字存储按照在原来整数中相反的顺序，使得第一个数字位于链表的开头。写出一个函数将两个整数相加，用链表形式返回和。
    * */

    /*Solution
    * 创建一个结果链表，链表每一个节点对应l1、l2两节点之和，注意保留进位以及对于进位的处理即可
    * */


    public ListNode addLists(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode curr=result;
        int count=0;
        while(l1!=null&&l2!=null){
            int value=l1.val+l2.val+count;
            count=value/10;
            curr.next=new ListNode(value%10);
            curr=curr.next;
            l1=l1.next;
            l2=l2.next;
        }
        if(l1==null){
            l1=l2;
        }
        while(l1!=null){
            int value=l1.val+count;
            count=value/10;
            curr.next=new ListNode(value%10);
            l1=l1.next;
            curr=curr.next;
        }
        if(count==1){
            curr.next=new ListNode(1);
        }
        return result.next;
        // write your code here
    }
}
