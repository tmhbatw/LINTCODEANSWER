package LINTCODE3;

import datastructure.ListNode;
import datastructure.TreeNode;

import java.util.*;

public class LINTCODE242 {
    /*Description
    * 给一棵二叉树，设计一个算法为每一层的节点建立一个链表。也就是说，如果一棵二叉树有 D 层，那么你需要创建 D 条链表。
    * */

    /*Solution
    * DFS算法即可
    * */

    public List<ListNode> binaryTreeToLists(TreeNode root) {
        if(root==null)
            return Collections.emptyList();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<ListNode> result=new ArrayList<>();
        while(!queue.isEmpty()){
            int size=queue.size();
            ListNode res=new ListNode(0);
            ListNode cur=res;
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                cur.next=new ListNode(curr.val);
                cur=cur.next;
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
            }
            result.add(res.next);
        }
        return result;
        // Write your code here
    }
}
