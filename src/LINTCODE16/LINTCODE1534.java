package LINTCODE16;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE1534 {
    /*Description
    * 将BST转换为已排序的循环双向链表。可以将左右指针视为双向链表中上一个和下一个指针的同义词。
    * */

    public TreeNode treeToDoublyList(TreeNode root) {
        if(root==null)
            return null;
        List<Integer> list=new ArrayList<>();
        getList(root,list);
        TreeNode result=new TreeNode(list.get(0));
        TreeNode pre=result;
        for(int i=1;i<list.size();i++){
            TreeNode cur=new TreeNode(list.get(i));
            pre.right=cur;
            cur.left=pre;
            pre=cur;
        }
        pre.right=result;
        result.left=pre;
        return result;
        // Write your code here.
    }

    private void getList(TreeNode root, List<Integer> list){
        if(root==null)
            return;
        getList(root.left,list);
        list.add(root.val);
        getList(root.right,list);
    }
}
