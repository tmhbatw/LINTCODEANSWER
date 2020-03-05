package LINTCODE16;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE1588 {
    /*Description
    * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
    * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
    * 答案中每个树的每个结点都必须有 node.val=0。
    * 你可以按任何顺序返回树的最终列表。
    * */

    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2==0)
            return Collections.emptyList();
        List<TreeNode> list=new ArrayList<>();
        if(n==1) {
            list.add(new TreeNode(0));
            return list;
        }
        for(int i=1;i<n-1;i+=2){
            List<TreeNode> left=allPossibleFBT(i);
            List<TreeNode> right=allPossibleFBT(n-i-1);
            for(TreeNode leftNode:left){
                for(TreeNode rightNode:right){
                    TreeNode res=new TreeNode(0);
                    res.left=leftNode;
                    res.right=rightNode;
                    list.add(res);
                }
            }
        }
        return list;
        // write your code here
    }


}
