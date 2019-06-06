package LINTCODE3;

import datastructure.Interval;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LINTCODE206 {
    /*Description
    *给定一个整数数组（下标由 0 到 n-1，其中 n 表示数组的规模），以及一个查询列表。每一个查询列表有两个整数 [start, end] 。
    *  对于每个查询，计算出数组中从下标 start 到 end 之间的数的总和，并返回在结果列表中。
    * */

    /*Solution
    * 与上一题思路基本相同，不过将值变为和而已
    * */

    class TreeNode{
        int start,end;
        Long sum;
        TreeNode left=null,right=null;
        public TreeNode(int start,int end){
            this.start=start;
            this.end=end;
        }
        public TreeNode(int start,int end,Long sum){
            this.start=start;
            this.end=end;
            this.sum=sum;
        }
    }

    private List<TreeNode> list=new ArrayList<>();
    public List<Long> intervalSum(int[] A, List<Interval> queries) {
        List<Long> result=new ArrayList<>();
        TreeNode tree=recursion(A,0,A.length-1);
        for(int i=list.size()-1;i>=0;i--){
            TreeNode curr=list.get(i);
            curr.sum=curr.left.sum+curr.right.sum;
        }
        for(int i=0;i<queries.size();i++){
            Interval curr=queries.get(i);
            result.add(getSum(tree,curr.start,curr.end));
        }
        return result;
        // write your code here
    }

    private TreeNode recursion(int[] A, int start, int end){
        if(start==end){
            return new TreeNode(start,end, (long) A[start]);
        }
        TreeNode root=new TreeNode(start,end);
        list.add(root);
        root.left=recursion(A,start,(start+end)/2);
        root.right=recursion(A,(start+end)/2+1,end);
        return root;
    }

    private Long getSum(TreeNode node, int start, int end){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(node);
        long result=0;
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur.start==start&&cur.end==end){
                return cur.sum;
            }
            if(cur.start>end||cur.end<start){
                continue;
            }
            if(cur.start>=start&&cur.end<=end){
                result+=cur.sum;
            }else {
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return result;
    }
}
