package LINTCODE16;

import datastructure.TreeNode;

public class LINTCODE1561 {
    /*Description
    * 给定一个integer数组（无序）和2个node值，按给出的数组构建 BST(需要按给定的数组元素顺序，
    * 挨个插入树中来构建BST)，找出这两个node在 BST 中的距离。
    * */

    public int bstDistance(int[] numbers, int node1, int node2) {
        if(numbers.length==0)
            return -1;
        boolean node1Exist=false;
        boolean node2Exist=false;
        TreeNode root=new TreeNode(numbers[0]);
        if(numbers[0]==node1)
            node1Exist=true;
        if(numbers[0]==node2)
            node2Exist=true;
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]==node1)
                node1Exist=true;
            if(numbers[i]==node2)
                node2Exist=true;
            addTreeNode(root,numbers[i]);
        }
        if(!node1Exist||!node2Exist)
            return -1;
        return search(root,node1,node2);
        // Write your code here
    }

    private int search(TreeNode root,int node1,int node2){
        if(root.val==node1)
            return search(root,node2);
        if(root.val==node2)
            return search(root,node1);
        if(root.val<node1&&root.val<node2)
            return search(root.right,node1,node2);
        if(root.val>node1&&root.val>node2)
            return search(root.left,node1,node2);
        return search(root,node1)+search(root,node2);
    }

    private int search(TreeNode root,int node1){
        if(root.val==node1)
            return 0;
        return 1+(root.val>node1?search(root.left,node1):search(root.right,node1));
    }

    private void addTreeNode(TreeNode root,int val){
        if(val>root.val){
            if(root.right==null)
                root.right=new TreeNode(val);
            else
                addTreeNode(root.right,val);
        }else{
            if(root.left==null)
                root.left=new TreeNode(val);
            else
                addTreeNode(root.left,val);
        }
    }
}
