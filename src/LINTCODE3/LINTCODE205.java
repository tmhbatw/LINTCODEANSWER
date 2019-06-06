package LINTCODE3;

import datastructure.Interval;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LINTCODE205 {
    /*Description
    * 给定一个整数数组（下标由 0 到 n-1，其中 n 表示数组的规模），以及一个查询列表。每一个查询列表有两个整数 [start, end]。
    *  对于每个查询，计算出数组中从下标 start 到 end 之间的数的最小值，并返回在结果列表中。
    * */

    /*Solution
    *构造一颗线性树，然后获取线性树中对应的最小值，即可获得结果
    * */

    class TreeNode{
        int start,end,min;
        TreeNode left=null,right=null;
        public TreeNode(int start,int end){
            this.start=start;
            this.end=end;
        }
        public TreeNode(int start,int end,int min){
            this.start=start;
            this.end=end;
            this.min=min;
        }
    }

    //将没有赋值最小值的节点全部保存在一个数据结构中，便于后续的赋值
    private List<TreeNode> list=new ArrayList<>();

    public List<Integer> intervalMinNumber(int[] A, List<Interval> queries) {
        List<Integer> result=new ArrayList<>();
        TreeNode tree=recursion(A,0,A.length-1);
        for(int i=list.size()-1;i>=0;i--){
            TreeNode curr=list.get(i);
            curr.min=(Math.min(curr.left.min,curr.right.min));
        }
        for(int i=0;i<queries.size();i++){
            Interval curr=queries.get(i);
            result.add(getMin(tree,curr.start,curr.end));
        }
        return result;
        // write your code here
    }

    private TreeNode recursion(int[] A,int start,int end){
        if(start==end){
            return new TreeNode(start,end,A[start]);
        }
        TreeNode root=new TreeNode(start,end);
        list.add(root);
        root.left=recursion(A,start,(start+end)/2);
        root.right=recursion(A,(start+end)/2+1,end);
        return root;
    }

    private int getMin(TreeNode node,int start,int end){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(node);
        int result=Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur.start==start&&cur.end==end){
                return cur.min;
            }
            if(cur.start>end||cur.end<start){
               continue;
             }
            if(cur.start>=start&&cur.end<=end){
                result=Math.min(result,cur.min);
            }else {
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return result;
    }
}
