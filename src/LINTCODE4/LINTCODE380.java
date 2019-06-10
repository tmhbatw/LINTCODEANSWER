package LINTCODE4;

import datastructure.ListNode;

public class LINTCODE380 {

    /*Description
    *Write a program to find the node at which the intersection of two singly linked lists begins
    * */

    /*Solution
    * 使A、B两节点从头出发，当走到尽头后指向另一节点的开头，那么走一定的路程后一定能走到相同的节点（因为走过相同的路程）
    * */


        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA==null||headB==null)
                return null;
            ListNode a=headA;
            ListNode b=headB;
            while (a != b){
                a=a==null?headB:a.next;
                b=b==null?headA:b.next;
            }
            return a;
            // write your code here
        }
}
