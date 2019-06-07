package LINTCODE3;

import datastructure.ListNode;

public class LINTCODE221 {

    /*Description
    * 将链表翻转，相加后返回翻转结果即可
    * */


    public ListNode addLists2(ListNode l1, ListNode l2) {
        l1=reverse(l1);
        l2=reverse(l2);
        ListNode result=new ListNode(0);
        ListNode cur=result;
        int count=0;
        while(l1!=null||l2!=null){
            int num1=l1==null?0:l1.val;
            int num2=l2==null?0:l2.val;
            int value=(num1+num2+count)%10;
            count=(num1+num2+count)/10;
            /*            System.out.println(value+"  "+count);*/
            cur.next=new ListNode(value);
            cur=cur.next;
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
        }
        if(count!=0)
            cur.next=new ListNode(1);
        return reverse(result.next);
        // write your code here
    }


    private ListNode reverse(ListNode l){
        ListNode cur=l,pre=null;
        ListNode next=cur;
        while(next!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

}
