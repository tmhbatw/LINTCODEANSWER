package LINTCODE2;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE164 {
    /*Description
    * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
    * */

    /*Solution
    * 下为一个很蠢的递归算法
    * */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result=recursion(1,n);
        return result;
        // write your code here
    }

    private List<TreeNode> recursion(int start,int end){
        List<TreeNode> result=new ArrayList<>();
        if(end<start){
            result.add(null);
            return result;
        }
        else if(end==start){
            result.add(new TreeNode(start));
            return result;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> left=recursion(start,i-1);
            List<TreeNode> right=recursion(i+1,end);
            for(int m=0;m<left.size();m++){
                for(int n=0;n<right.size();n++){
                    TreeNode root=new TreeNode(i);
                    root.left=left.get(m);
                    root.right=right.get(n);
                    result.add(root);
                }
            }
        }
        return result;
    }
}
