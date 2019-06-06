package LINTCODE3;

import datastructure.Interval;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LINTCODE207 {
    /*Description
    *在类的构造函数中给一个整数数组, 实现两个方法 query(start, end) 和 modify(index, value):
    * 对于 query(start, end), 返回数组中下标 start 到 end 的 和。
    * 对于 modify(index, value), 修改数组中下标为 index 上的数为 value.
    * */

    /*Solution
    * 和前面的题目没有什么不同的
    * （有病吧整这么多一样的）``````````````````
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

    private TreeNode node=null;

    private List<TreeNode> list=new ArrayList<>();

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

    public LINTCODE207(int[] A) {
        if(A.length==0)
            return;
        node=recursion(A,0,A.length-1);
        for(int i=list.size()-1;i>=0;i--){
            TreeNode curr=list.get(i);
            curr.sum=curr.left.sum+curr.right.sum;
        }
        // do intialization if necessary
    }

    /*
     * @param start: An integer
     * @param end: An integer
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        return getSum(node,start,end);
        // write your code here
    }

    /*
     * @param index: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void modify(int index, int value) {
        List<TreeNode> lis=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            if(curr.start==index&&curr.end==index){
                curr.sum= Long.valueOf(value);
                break;
            }
            if(curr.start<=index&&curr.end>=index){
                lis.add(curr);
                if(curr.left!=null){
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
        }
        for(int j=lis.size()-1;j>=0;j--){
            TreeNode cur=lis.get(j);
            cur.sum=cur.left.sum+cur.right.sum;
        }
        // write your code here
    }
}
