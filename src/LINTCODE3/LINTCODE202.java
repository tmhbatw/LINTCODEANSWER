package LINTCODE3;

import datastructure.SegmentTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LINTCODE202 {
    /*Description
    * 为SegmentTree设计一个 query 的方法，接受3个参数root, start和end，线段树root所代表的数组中子区间[start, end]内的最大值。
    * */

    /*Solution
    * BFS算法遍历所有的节点即可，需要注意的是有可能不存在完全符合的节点，返回上一节点的max值即可
    * */
/*    public int query(SegmentTreeNode root, int start, int end) {
        Queue<SegmentTreeNode> queue=new LinkedList<>();
        queue.add(root);
        int result=-1;
        while(!queue.isEmpty()){
            SegmentTreeNode curr=queue.poll();
            if(curr.start==start&&curr.end==end)
                return curr.max;
            if(curr.start>=start&&curr.end<=end){
                result=Math.max(result,curr.max);
            }

            if(curr.left!=null&&curr.left.end>=start) {
                queue.add(curr.left);
            }
            if(curr.right!=null&&curr.right.start<=end) {
                queue.add(curr.right);
            }
        }
        return result;
        // write your code here
    }*/
}
