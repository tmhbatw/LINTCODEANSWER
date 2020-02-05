package LINTCODE12;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LINTCODE1165 {
    /*Description
    * 给定两个非空二叉树s和t，检查树t是否和树s的一个子树具有完全相同的结构和节点值。
    * s的子树是一个由s中的一个节点和该节点的后续组成的树。 树s本身也可以被视为自己的一个子树。
    * */

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null)
            return false;
        List<TreeNode> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur.val==t.val)
                list.add(cur);
            if(cur.left!=null)
                queue.add(cur.left);
            if(cur.right!=null)
                queue.add(cur.right);
        }
        for(TreeNode cur:list)
            if(isSame(cur,t))
                return true;
        return false;
        // Write your code here
    }

    private boolean isSame(TreeNode s,TreeNode t){
        if(s==null&&t==null)
            return true;
        if(s==null||t==null||s.val!=t.val)
            return false;
        return isSame(s.left,t.left)&&isSame(s.right,t.right);
    }
}
