package LINTCODE13;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LINTCODE1203 {
    /*Description
    * 给定具有重复项的二叉搜索树（BST），找到给定BST中的所有modes（最频繁出现的元素）。
    * 在这里假设一个BST定义如下：
    * 节点的左子树仅包含键小于或等于父节点的节点.
    * 节点的右子树仅包含键大于或等于父节点的节点。
    * 左右子树也必须是二叉搜索树。
    * */

    public int[] findMode(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        preOrder(root,res);
        int maxTime=0;
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<res.size();i++){
            int time=i;
            while(i<res.size()-1&& res.get(i + 1).equals(res.get(i)))
                i++;
            time=i-time+1;
            if(time==maxTime)
                result.add(res.get(i));
            if(time>maxTime){
                maxTime=time;
                result=new ArrayList<>();
                result.add(res.get(i));
            }
        }
        int[] re=new int[result.size()];
        for(int i=0;i<re.length;i++)
            re[i]=result.get(i);
        return re;
        // write your code here
    }

    private void preOrder(TreeNode node, List<Integer> res){
        if(node==null)
            return;
        preOrder(node.left,res);
        res.add(node.val);
        preOrder(node.right,res);
    }
}
