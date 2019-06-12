package LINTCODE5;

import java.util.ArrayList;
import java.util.List;

public class LINTCODE439 {

    /*Description
    * 线段树是一棵二叉树，他的每个节点包含了两个额外的属性start和end用于表示该节点所代表的区间。start和end都是整数，并按照如下的方式赋值:
    * 根节点的 start 和 end 由 build 方法所给出。
    * 对于节点 A 的左儿子，有 start=A.left, end=(A.left + A.right) / 2。
    * 对于节点 A 的右儿子，有 start=(A.left + A.right) / 2 + 1, end=A.right。
    * 如果 start 等于 end, 那么该节点是叶子节点，不再有左右儿子。
    * 对于给定数组实现build方法, 线段树的每个节点储存区间最大值, 返回根节点.
    * */

    /*Solution
    * 做过多次原题
    * */

    public class SegmentTreeNode {
      public int start, end, max;
      public SegmentTreeNode left, right;
      public SegmentTreeNode(int start, int end, int max) {
          this.start = start;
          this.end = end;
          this.max = max;
          this.left = this.right = null;
      }
    }

    List<SegmentTreeNode> list=new ArrayList<>();
    public SegmentTreeNode build(int[] A) {
        if(A.length==0)
            return null;
        SegmentTreeNode result=getNode(A,0,A.length-1);
        for(int i=list.size()-1;i>=0;i--){
            SegmentTreeNode cur=list.get(i);
            cur.max=Math.max(cur.left.max,cur.right.max);
        }
        return result;
        // write your code here
    }

    private SegmentTreeNode getNode(int[] A,int start ,int end){
        if(start==end){
            return new SegmentTreeNode(start,end,A[start]);
        }
        SegmentTreeNode curr=new SegmentTreeNode(start,end,0);
        list.add(curr);
        curr.left=getNode(A,start,(start+end)/2);
        curr.right=getNode(A,(start+end)/2+1,end);
        return curr;
    }
}
