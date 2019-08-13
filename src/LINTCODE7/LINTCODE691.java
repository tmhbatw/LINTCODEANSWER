package LINTCODE7;

import datastructure.ListNode;
import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE691 {
    /*Description
    *在一棵二叉搜索树中, 只有两个节点是被交换的. 找到这些节点并交换, 如果没有节点被交换就返回原来的树的根节点.
    * */

    TreeNode node1=null;
    TreeNode pre=null;
    TreeNode node2=null;
    TreeNode last=null;
    //继续优化
    public TreeNode bstSwappedNode(TreeNode root) {
        if(root==null)
            return null;
        pre=root;
        while(pre.left!=null){
            pre=pre.left;
        }
        findFirstNode(root);
        if(node1==null)
            return root;
        System.out.println(node1.val);
        last=root;
        while(pre.right!=null){
            pre=pre.right;
        }
        findLastNode(root);
        System.out.println(node2.val);
        int temp=node1.val;
        node1.val=node2.val;
        node2.val=temp;
        return root;
        // write your code here
    }

    private void findLastNode(TreeNode root){
        if(node2!=null||root==null)
            return;
        findLastNode(root.right);
        if(root.val>last.val){
            if(node2==null){
                node2=last;
            }
            return;
        }else{
            last=root;
        }
        findLastNode(root.left);
    }

    private void findFirstNode(TreeNode root){
        if(node1!=null||root==null)
            return;
        findFirstNode(root.left);
        if(root.val<pre.val){
            if(node1==null){
                node1=pre;
            }
            return;
        }else{
            pre=root;
        }
        findFirstNode(root.right);
    }
/*
{49,37,99,35,39,53,100,12,31,38,40,52,63,#,#,10,16,34,36,#,#,#,48,50,#,62,96,6,11,15,27,32,#,#,#,45,#,#,51,58,#,68,98,3,9,
#,#,14,#,20,29,#,33,42,47,#,#,57,61,67,87,97,#,2,4,8,#,13,#,17,25,28,30,#,#,41,44,46,#,55,#,59,#,64,#,75,92,#,#,1,#,#,5,7,
#,#,#,#,19,22,26,#,#,#,#,#,#,43,#,#,#,54,56,#,60,#,66,69,77,91,93,#,#,#,#,#,#,18,#,21,24,#,#,#,#,#,#,#,#,#,#,65,#,#,71,76,
78,88,#,#,95,#,#,#,#,23,#,#,#,70,72,#,#,#,81,#,90,94,#,#,#,#,#,#,74,79,84,89,#,#,#,73,#,#,80,82,86,#,#,#,#,#,#,#,83,85}
* */




    //优化版本
/*    TreeNode node1=null;
    TreeNode node2=null;
    public TreeNode bstSwappedNode(TreeNode root) {
        if(root==null)
            return null;
        List<TreeNode> list=new ArrayList<>();
        findFirstNode(root,list);
        if(node1==null)
            return root;
        List<TreeNode> lists=new ArrayList<>();
        findLastNode(root,lists);
        int temp=node1.val;
        node1.val=node2.val;
        node2.val=temp;
        return root;
        // write your code here
    }

    private void findLastNode(TreeNode node,List<TreeNode> list){
        if(node2!=null||node==null)
            return;
        findLastNode(node.right,list);
        list.add(node);
        int index=list.size();
        if(index!=1&&list.get(index-1).val>list.get(index-2).val){
            if(node2==null){
                node2=list.get(index-2);
            }
            return ;
        }
        findLastNode(node.left,list);
    }

    private void findFirstNode(TreeNode node,List<TreeNode> list){
        if(node1!=null||node==null)
            return ;
        findFirstNode(node.left,list);
        list.add(node);
        int index=list.size();
        if(index!=1&&list.get(index-1).val<list.get(index-2).val){
            if(node1==null){
                node1=list.get(index-2);
            }
            return;
        }
        findFirstNode(node.right,list);
    }*/



    //初始算法
/*    public TreeNode bstSwappedNode(TreeNode root) {
        if(root==null)
            return null;
        List<TreeNode> list=new ArrayList<>();
        inorderList(root,list);
        TreeNode node1=null;
        for(int i=1;i<list.size();i++){
            if(list.get(i).val<list.get(i-1).val){
                node1=list.get(i-1);
                break;
            }
        }
        if(node1==null)
            return root;
        TreeNode node2=null;
        for(int j=list.size()-1;j>=0;j--){
            if(list.get(j).val<list.get(j-1).val){
                node2=list.get(j);
                break;
            }
        }
        int temp=node1.val;
        node1.val=node2.val;
        node2.val=temp;
        return root;
        // write your code here
    }

    private void inorderList(TreeNode root, List<TreeNode> list){
        if(root==null)
            return;
        inorderList(root.left,list);
        list.add(root);
        inorderList(root.right,list);
    }*/
}
