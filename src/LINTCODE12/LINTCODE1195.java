package LINTCODE12;

import datastructure.TreeNode;

import java.util.*;

public class LINTCODE1195 {
    /*Description
    *你需要找到在一棵二叉树中，每一行的最大值
    * */

    public List<Integer> largestValues(TreeNode root) {
        if(root==null)
            return Collections.emptyList();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<Integer> result=new ArrayList<>();
        while(!queue.isEmpty()){
            int size=queue.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                if(cur.left!=null)
                    queue.add(cur.left);
                if(cur.right!=null)
                    queue.add(cur.right);
                max=Math.max(max,cur.val);
            }
            result.add(max);
        }
        return result;
        // write your code here
    }
}
