package LINTCODE3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LINTCODE249 {
    /*Description
    * 给定一个整数数组（下标由 0 到 n-1， n 表示数组的规模，取值范围由 0 到10000）。
    * 对于数组中的每个 ai 元素，请计算 ai 前的数中比它小的元素的数量。
    * */

    /*Solution
    * 遍历方法gg
    * 可能需要构建一颗线段树，每个节点保存最大值，然后进行比,依然gg？？
    * 修改构建树的方法，创建一个0-10000的树，保存每一个区间的节点的个数即可
    * */

    class TreeNode{
        int start,end,num;
        TreeNode left=null;
        TreeNode right=null;
        public TreeNode(int start,int end,int num){
            this.start=start;
            this.end=end;
            this.num=num;
        }
    }

    private TreeNode root;

    public List<Integer> countOfSmallerNumberII(int[] A) {
        if(A.length==0)
            return null;
        List<Integer> result=new ArrayList<>();
        root=getTree(0,10000);
        result.add(0);
        for(int i=1;i<A.length;i++){
            result.add(getNum(root,0,A[i]-1));
            increase(root,A[i]);
        }
        return result;

        // write your code here
    }

    public void increase(TreeNode node,int i){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur.start<=i&&cur.end>=i){
                cur.num=cur.num+1;
                if(cur.left!=null){
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
        }
    }

    public int getNum(TreeNode node,int start,int end){
        if(node.start>=start&&node.end<=end){
            return node.num;
        }
        else if(node.start>end||node.end<start)
            return 0;
        else {
            return getNum(node.left,start,end)+getNum(node.right,start,end);
        }
    }

    //创建一棵树
    public  TreeNode getTree(int start,int end){
        TreeNode cur=new TreeNode(start,end,0);
        if(start==end){
            return cur;
        }
        cur.left= getTree(start, (start+end)/2);
        cur.right=getTree((start+end)/2+1,end);
        return cur;
    }

/*    public List<Integer> countOfSmallerNumberII(int[] A) {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<A.length;i++){
            int count=0;
            for(int j=0;j<i;j++){
                if(A[j]<A[i])
                    count++;
            }
            result.add(count);
        }
        return result;
        // write your code here
    }*/
}
