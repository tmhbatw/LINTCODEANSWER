package LINTCODE13;

import datastructure.TreeNode;

public class LINTCODE1240 {
    /*Description
    * 给定一个二叉树，它的每个结点都存放着一个整数值。找出路径和等于给定数值的路径总数。
    * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
    * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
    * */

    public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        return pathSum(root.left,sum)+pathSum(root.right,sum)+function(root,0,sum);
        // write your code here
    }


    private int function(TreeNode root,int curSum,int sum){
        if(root==null)
            return 0;
        System.out.println(curSum+" "+root.val+"  "+(curSum==sum?1:0));
        curSum+=root.val;

        return function(root.left,curSum,sum)+function(root.right,curSum,sum)+curSum==sum?1:0;

    }
}
