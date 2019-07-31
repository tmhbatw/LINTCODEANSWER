package LINTCODE6;

import datastructure.ListNode;

public class LINTCODE599 {
    /*Description
    * 给一个来自已经排过序的循环链表的节点，写一个函数来将一个值插入到循环链表中，并且保持还是有序循环链表。
    * 给出的节点可以是链表中的任意一个单节点。返回插入后的新链表。
    * */

    public ListNode insert(ListNode node, int x) {
        ListNode start=node;
        while(node!=null){
            if(x>node.val&&x<=node.next.val||x>node.val&&node.next.val<node.val||x<node.val&&x<=node.next.val&&node.val>node.next.val||node==node.next) {
                ListNode next = node.next;
                node.next = new ListNode(x);
                node.next.next = next;
                return node;
            }
            node=node.next;
            if(node==start){
                ListNode next = node.next;
                node.next = new ListNode(x);
                node.next.next = next;
                return node;
            }
        }
        ListNode res=new ListNode(x);
        res.next=res;
        return res;
        // write your code here
    }
}
