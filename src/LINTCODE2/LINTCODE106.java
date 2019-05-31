package LINTCODE2;

import datastructure.ListNode;
import datastructure.TreeNode;
import sun.reflect.generics.tree.Tree;

public class LINTCODE106 {
    /*Description
    * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
    *
    * */

    /*Solution
    * 通过快慢节点可以找到链表中的中间节点，该节点即为二叉树的根节点
    * 链表中间节点的左边节点为二叉树的左子树，链表中间节点的右边节点即为二叉树的右子树
    * 递归即可
    * */
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        //通过快慢节点找到中间节点
        ListNode fast=head;
        ListNode slow=head;
        ListNode start=new ListNode(0);
        start.next=head;
        ListNode curr=start;
        while(true){
            if(fast==null||fast.next==null)
                break;
            slow=slow.next;
            curr=curr.next;
            fast=fast.next.next;
        }
        curr.next=null;
        TreeNode root=new TreeNode(slow.val);
        root.left=curr==start?null:sortedListToBST(start.next);
        root.right=slow.next==null?null:sortedListToBST(slow.next);
        return root;

        // write your code here
    }
}
