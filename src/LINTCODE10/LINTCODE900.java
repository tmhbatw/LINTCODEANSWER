package LINTCODE10;

import datastructure.TreeNode;

public class LINTCODE900 {
    /*Description
    * 给一棵非空二叉搜索树以及一个target值，找到在BST中最接近给定值的节点值
    * */

    /*Solution
    * 遍历二叉树
    * */

    public int closestValue(TreeNode root, double target) {
        double difference=Double.MAX_VALUE;
        int res=root.val;
        while(root!=null){
            if(Math.abs(target-root.val)<difference){
                difference=Math.abs(target-root.val);
                res=root.val;
            }
            if(target>root.val)
                root=root.right;
            else{root=root.left;}
        }
        return res;
        // write your code here
    }
}
