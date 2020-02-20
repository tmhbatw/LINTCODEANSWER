package LINTCODE12;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE1122 {

    /*Description
    * 给定二叉树的根，然后是值v和深度d，您需要在给定深度d处添加一行值为v的节点。 根节点位于深度1。
    * 添加规则是：给定正整数深度d，对于深度为d-1的每一个非空树节点 N，产生两个值为v的树节点，
    * 分别作为 N 的左子树根和右子树根。并且 N 的原始左子树应该是新左子树根的左子树，其原始右子树应该是新右子树根的右子树。
    *  如果深度d为1表示根本没有深度d-1，则创建一个值为v的树节点作为整个原始树的新根，并且原始树是新根的左子树。
    * */

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1){
            TreeNode res=new TreeNode(v);
            res.left=root;
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            d--;
            if(d==1){
                for(int i=0;i<size;i++){
                    TreeNode cur=queue.poll();
                    TreeNode node1=new TreeNode(v);
                    TreeNode left=cur.left;
                    cur.left=node1;
                    node1.left=left;
                    TreeNode node2=new TreeNode(v);
                    TreeNode right=cur.right;
                    cur.right=node2;
                    node2.right=right;

                }
            }
            else{
                for(int i=0;i<size;i++){
                    TreeNode cur=queue.poll();
                    if(cur.left!=null)
                        queue.add(cur.left);
                    if(cur.right!=null)
                        queue.add(cur.right);
                }
            }
        }
        return root;
        // write your code here
    }
}
