package LINTCODE5;

import datastructure.ListNode;

import java.util.List;

public class LINTCODE489 {
    /*Description
    * 将一个数组变成链表
    * */

    public ListNode toLinkedList(List<Integer> nums) {
        ListNode result=new ListNode(0);
        ListNode cur=result;
        for(int num:nums){
            cur.next=new ListNode(num);
            cur=cur.next;
        }
        return result.next;
        // write your code here
    }
}
