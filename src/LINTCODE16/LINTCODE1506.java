package LINTCODE16;

import datastructure.TreeNode;

import java.util.*;

public class LINTCODE1506 {
    /*Description
    * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
    * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
    * */

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode,TreeNode> map=new HashMap<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        TreeNode cur=root;
        while(!queue.isEmpty()){
            cur=queue.poll();
            TreeNode left=cur.left;
            if(left!=null){
                map.put(left,cur);
                queue.add(left);
            }
            TreeNode right=cur.right;
            if(right!=null){
                map.put(right,cur);
                queue.add(right);
            }
            if(cur==target)
                break;
        }
        List<Integer> result=new ArrayList<>();
        TreeNode pre=cur;
        insert(result,target,null,K);
        while(K-->=0){
            if(!map.containsKey(pre))
                break;
            cur=map.get(pre);
            insert(result,cur,pre,K);
            pre=cur;
        }
        return result;
        // Write your code here
    }

    private void insert(List<Integer> result,TreeNode cur,TreeNode delete,int k){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(cur);
        while(!queue.isEmpty()){
            if(k==0)
                break;
            k--;
            int size=queue.size();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                TreeNode left = node.left;
                if (left != null && left != delete)
                    queue.add(left);
                TreeNode right = node.right;
                if (right != null && right != delete)
                    queue.add(right);
            }
        }
        while(!queue.isEmpty())
            result.add(queue.poll().val);
    }
}
