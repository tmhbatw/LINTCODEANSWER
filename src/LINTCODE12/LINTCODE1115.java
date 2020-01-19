package LINTCODE12;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LINTCODE1115 {
    /*Description
    * 给定非空二叉树，以数组的形式返回每一层上的节点的平均值。
    * */

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            double cur=0;
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
                cur+=curr.val;
            }
            result.add(cur/size);
        }
        return result;
        // write your code here
    }

    public static void main(String[] args){
        double cur=2;
        System.out.println(cur/4);
    }


}
