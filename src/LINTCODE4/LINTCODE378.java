package LINTCODE4;

import datastructure.DoublyListNode;
import datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE378 {
    /*Description
    * Convert a binary tree to doubly linked list with in-order traversal.
    * */

    /*Solution
    * 略微不太了解这样转化的目的是什么
    * 大概中序遍历树并将其转化为一个双向链表吧
    * */

    public DoublyListNode bstToDoublyList(TreeNode root) {
        if(root==null)
            return null;
        Queue<Integer> queue=new LinkedList<>();
        getNumber(queue,root);
        DoublyListNode result=new DoublyListNode(queue.poll());
        DoublyListNode curr=result;
        while(!queue.isEmpty()){
            curr.next=new DoublyListNode(queue.poll());
            curr=curr.next;
        }
        return result;
        // write your code here
    }

    private void getNumber(Queue<Integer> queue,TreeNode root){
        if(root==null)
            return;
        getNumber(queue,root.left);
        queue.add(root.val);
        getNumber(queue,root.right);
    }
}
