package LINTCODE5;

import datastructure.ParentTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LINTCODE472 {
    /*Description
    * 给一棵二叉树和一个目标值，找到二叉树上所有的和为该目标值的路径。路径可以从二叉树的任意节点出发，任意节点结束。
    * */

    class ParentTreeNode {
        public int val;
        public ParentTreeNode parent, left, right;
    }

    static class Node{
        int sum;
        List<Integer> list;
        public Node(List<Integer> list,int sum){
            this.list=list;
            this.sum=sum;
        }
    }

    List<List<Integer>> r=new ArrayList<>();
    int target;

    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        this.target=target;
        dfs(root);
        return r;
        // write your code here
    }

    public List<Node> dfs(ParentTreeNode root){
        List<Node> result=new ArrayList<>();
        result.add(new Node(new ArrayList<>(), 0));

        if(root==null){
            return result;
        }
        List<Node> l1=dfs(root.left);
        List<Node> l2=dfs(root.right);

        for(Node cur1:l1){
            for(Node cur2:l2){
                if(cur1.sum+cur2.sum+root.val==target){
                    List<Integer> curRes = new ArrayList<>(cur1.list);
                    curRes.add(root.val);
                    List<Integer> list2=new ArrayList<>(cur2.list);
                    Collections.reverse(list2);
                    curRes.addAll(list2);
                    r.add(curRes);

                    if(curRes.size()>1){
                        List<Integer> curr=new ArrayList<>(curRes);
                        Collections.reverse(curr);
                        r.add(curr);
                    }
                }
            }
        }

        addList(root, (List<Node>) result, (List<Node>) l1);
        addList(root, (List<Node>) result, (List<Node>) l2);

        List<Integer> l=new ArrayList<>();
        l.add(root.val);
        result.add(new Node(l, root.val));

        return result;
    }

    private void addList(ParentTreeNode root, List<Node> result, List<Node> l2) {
        for(Node cur:l2){
            if(cur.list.size()>0){
                List<Integer> l=new ArrayList<>(cur.list);
                l.add(root.val);
                result.add(new Node(l, cur.sum + root.val));
            }
        }
    }

    public static void main(String[] args){
        List<Integer> l=new ArrayList<>();
        l.add(1);
        l.add(2);
        System.out.println(l);
    }
}
