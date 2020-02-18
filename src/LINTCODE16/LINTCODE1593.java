package LINTCODE16;

import datastructure.TreeNode;

public class LINTCODE1593 {
    /*Description
    * 返回与给定的前序和后序遍历匹配的任何二叉树。
    * pre 和 post 遍历中的值是不同的正整数。
    * */

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return recursion(pre,post,0,pre.length,0,post.length);
           // write your code here
    }

    private TreeNode recursion(int[] pre,int[] post,int preLeft,int preRight,int postLeft,int postRight){
        if(preRight<preLeft)
            return null;
        if(preLeft==preRight)
            return new TreeNode(pre[preLeft]);
        TreeNode res=new TreeNode (pre[preLeft]);
        int left=pre[preLeft+1];
        int index=postLeft;
        while(post[index]!=left)
            index++;
        res.left=recursion(pre,post,preLeft+1,index-postLeft+preLeft+1,postLeft,index);
        res.right=recursion(pre,post,index-postLeft+preLeft+2,preRight,index+1,postRight);
        return res;
    }
}
