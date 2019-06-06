package LINTCODE4;

import datastructure.ListNode;

public class LINTCODE372 {

    /*Description
    * Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
    * */

    /*Solution
    * 因为没有办法获取当前节点的上一节点，所以只能将下一节点的值赋给当前节点，然后删去下一节点
    * */
    public void deleteNode(ListNode node) {
        if(node==null)
            node=new ListNode(1);
        node.val=node.next.val;
        node.next=node.next.next;
        // write your code here
    }
}
