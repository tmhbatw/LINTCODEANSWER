package LINTCODE3;

import datastructure.SegmentTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE247 {
    /*Description
    * 对于一个数组，我们可以对其建立一棵 线段树, 每个结点存储一个额外的值 count 来代表这个结点所指代的数组区间内的元素个数. (数组中并不一定每个位置上都有元素)
    * 实现一个 query 的方法，该方法接受三个参数 root, start 和 end, 分别代表线段树的根节点和需要查询的区间，找到数组中在区间[start, end]内的元素个数。
    * */

    /*Solution
    * 和先前的与线段树有关的题目看不出来有什么不同
    * */

    public int query(SegmentTreeNode root, int start, int end) {
        if(root==null)
            return 0;
        Queue<SegmentTreeNode> queue=new LinkedList<>();
        queue.add(root);
        int result=0;
        while(!queue.isEmpty()){
            SegmentTreeNode cur=queue.poll();
            if(cur.start==start&&cur.end==end)
                return cur.count;
            if(cur.start>=start&&cur.end<=end){
                result+=cur.count;
                continue;
            }
            if(cur.start>end||cur.end<start)
                continue;
            if(cur.left!=null)
                queue.add(cur.left);
            if(cur.right!=null)
                queue.add(cur.right);
        }
        return result;

        // write your code here
    }
}
