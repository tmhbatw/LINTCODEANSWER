package LINTCODE3;

import datastructure.SegmentTreeNode;

public class LINTCODE201 {

    /*Description
    *线段树是一棵二叉树，他的每个节点包含了两个额外的属性start和end用于表示该节点所代表的区间。start和end都是整数，并按照如下的方式赋值:
    * 根节点的 start 和 end 由 build 方法所给出。
    * 对于节点 A 的左儿子，有 start=A.left, end=(A.left + A.right) / 2。
    * 对于节点 A 的右儿子，有 start=(A.left + A.right) / 2 + 1, end=A.right。
    * 如果 start 等于 end, 那么该节点是叶子节点，不再有左右儿子。
    * 实现一个 build 方法，接受 start 和 end 作为参数, 然后构造一个代表区间 [start, end] 的线段树，返回这棵线段树的根。
    * */

    /*Solution
    * 递归遍历即可
    * */

    public SegmentTreeNode build(int start, int end) {
        if(start>end)
            return null;
        return recursion(start,end);
        // write your code here
    }

    private SegmentTreeNode recursion(int start,int end){
        if(start==end){
            return new SegmentTreeNode(start,end);
        }
        SegmentTreeNode root=new SegmentTreeNode(start,end);
        root.left=recursion(start,(start+end)/2);
        root.right=recursion((start+end)/2+1,end);
        return root;
    }
}
