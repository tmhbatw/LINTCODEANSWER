package LINTCODE;

import datastructure.TreeNode;

import java.util.Stack;

public class LINTCODE86 {

    /*Description
    * 设计实现一个带有下列属性的二叉查找树的迭代器：
    * next()返回BST中下一个最小的元素
    * 元素按照递增的顺序被访问（比如中序遍历）
    * next()和hasNext()的询问操作要求均摊时间复杂度是O(1)
    * */

    /*Solution
    * 因为是一颗二叉树所以左边的数一定小于右边
    * 将root节点以及其左节点、左节点的左节点等等等等压入栈中，则栈中头元素即为最小的节点
    * 当最小节点含有右节点时，其值也一定小于他的父节点
    * 因此将它与它的左节点、左节点的左节点等等等等压入栈中
    * 递归即可
    * */

    private Stack<TreeNode> stack=new Stack<>();

    public LINTCODE86(TreeNode root) {
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
        // do intialization if necessary
    }

    public boolean hasNext() {
        return !stack.empty();
        // write your code here
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        TreeNode result=stack.pop();
        TreeNode n=result.right;
        while(n!=null){
            stack.push(n);
            n=n.left;
        }
        return result;

        // write your code here
    }
}
