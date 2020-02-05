package LINTCODE3;

import datastructure.SegmentTreeNode;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE203 {

    /*Description
    *对于一棵 最大线段树, 每个节点包含一个额外的 max 属性，用于存储该节点所代表区间的最大值。
    * 设计一个 modify 的方法，接受三个参数 root、 index 和 value。该方法将 root 为根的线段树中 [start, end] = [index, index] 的节点修改为了新的 value ，
    * 并确保在修改后，线段树的每个节点的 max 属性仍然具有正确的值。
    *Challenge
    * 时间复杂度 O(h) , h 是线段树的高度
    *  */

    /*Solution
    *用一个list保存所有与被修该的节点有关的节点，在最小的子节点被修改后依次修改父节点即可
    * */

/*    public void modify(SegmentTreeNode root, int index, int value) {
        if(root==null||root.start>value||root.end<value)
            return;
        List<SegmentTreeNode> list=new ArrayList<>();
        while(root!=null){
            if(root.start==index&&root.end==index) {
                root.max = value ;
                break;
            }
            list.add(root);
            if(root.left!=null&&root.left.end>=value&&root.left.start<=value)
                root=root.left;
            else if(root.right!=null&&root.right.end>=value&&root.right.start<=value)
                root=root.right;
            else
                break;
        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).left+"  "+list.get(i).right);
        }
        for(int j=list.size()-1;j>=0;j--){
            SegmentTreeNode curr=list.get(j);
            if(curr.left==null&&curr.right==null){

            } else if(curr.left==null){
                curr.max=curr.right.max;
            }else if(curr.right==null){
                curr.max=curr.left.max;
            }else if(curr.left!=null&&curr.right!=null){
                curr.max=Math.max(curr.left.max,curr.right.max);
            }
        }
        // write your code here
    }*/
}
